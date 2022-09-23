import { type FC, useEffect } from "react";
import { EditItem as EditItemModal } from "@chia/components/Modal";
import EditShieldList from "./EditShieldList";
import { useAppDispatch } from "@chia/hooks/useAppDispatch";
import { useAppSelector } from "@chia/hooks/useAppSelector";
import { getAllShieldsAsync } from "@chia/store/modules/Shield/actions";
import { selectAllShields } from "@chia/store/modules/Shield";
import {
  selectActionSheet,
  activeEditShieldModal,
} from "@chia/store/modules/ActionSheet";
import { Loading } from "@geist-ui/core";
import { useReadLocalStorage } from "usehooks-ts";
import { LocalUser } from "@chia/shared/types";

const EditShieldModal: FC = () => {
  const dispatch = useAppDispatch();
  const shields = useAppSelector(selectAllShields);
  const actionSheet = useAppSelector(selectActionSheet);
  const userData = useReadLocalStorage<LocalUser>("userData");

  useEffect(() => {
    if (!shields.data && actionSheet.editShieldModal.isOpen)
      // @ts-ignore
      dispatch(getAllShieldsAsync(userData.token));
  }, [actionSheet.editShieldModal.isOpen]);

  return (
    <EditItemModal
      isOpen={actionSheet.editShieldModal.isOpen}
      onClose={() => dispatch(activeEditShieldModal())}
      title={"Shield"}>
      {shields.loading === "pending" && <Loading>Loading</Loading>}
      {shields.loading === "succeeded" && (
        // @ts-ignore
        <EditShieldList shields={shields.data} />
      )}
    </EditItemModal>
  );
};

export default EditShieldModal;
