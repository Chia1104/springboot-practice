import { type FC, useEffect } from "react";
import { EditItem as EditItemModal } from "@chia/components/Modal";
import EditArmorList from "./EditArmorList";
import { useAppDispatch } from "@chia/hooks/useAppDispatch";
import { useAppSelector } from "@chia/hooks/useAppSelector";
import { getAllArmorsAsync } from "@chia/store/modules/Armor/actions";
import { selectAllArmors } from "@chia/store/modules/Armor";
import {
  selectActionSheet,
  activeEditArmorModal,
} from "@chia/store/modules/ActionSheet";
import { Loading } from "@geist-ui/core";
import { useReadLocalStorage } from "usehooks-ts";
import { LocalUser } from "@chia/shared/types";

const EditArmorModal: FC = () => {
  const dispatch = useAppDispatch();
  const armors = useAppSelector(selectAllArmors);
  const actionSheet = useAppSelector(selectActionSheet);
  const userData = useReadLocalStorage<LocalUser>("userData");

  useEffect(() => {
    if (!armors.data && actionSheet.editArmorModal.isOpen)
      // @ts-ignore
      dispatch(getAllArmorsAsync(userData.token));
  }, [actionSheet.editArmorModal.isOpen]);

  return (
    <EditItemModal
      isOpen={actionSheet.editArmorModal.isOpen}
      onClose={() => dispatch(activeEditArmorModal())}
      title={"Armor"}>
      {armors.loading === "pending" && <Loading>Loading</Loading>}
      {armors.loading === "succeeded" && (
        // @ts-ignore
        <EditArmorList armors={armors.data} />
      )}
    </EditItemModal>
  );
};

export default EditArmorModal;
