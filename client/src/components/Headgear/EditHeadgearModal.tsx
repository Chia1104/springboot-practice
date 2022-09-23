import { type FC, useEffect } from "react";
import { EditItem as EditItemModal } from "@chia/components/Modal";
import EditHeadgearList from "./EditHeadgearList";
import { useAppDispatch } from "@chia/hooks/useAppDispatch";
import { useAppSelector } from "@chia/hooks/useAppSelector";
import { getAllHeadgearAsync } from "@chia/store/modules/Headgear/actions";
import { selectAllHeadgear } from "@chia/store/modules/Headgear";
import {
  selectActionSheet,
  activeEditHeadgearModal,
} from "@chia/store/modules/ActionSheet";
import { Loading } from "@geist-ui/core";
import { useReadLocalStorage } from "usehooks-ts";
import { LocalUser } from "@chia/shared/types";

const EditHeadgearrModal: FC = () => {
  const dispatch = useAppDispatch();
  const headgears = useAppSelector(selectAllHeadgear);
  const actionSheet = useAppSelector(selectActionSheet);
  const userData = useReadLocalStorage<LocalUser>("userData");

  useEffect(() => {
    if (!headgears.data && actionSheet.editHeadgearModal.isOpen)
      // @ts-ignore
      dispatch(getAllHeadgearAsync(userData.token));
  }, [actionSheet.editHeadgearModal.isOpen]);

  return (
    <EditItemModal
      isOpen={actionSheet.editHeadgearModal.isOpen}
      onClose={() => dispatch(activeEditHeadgearModal())}
      title={"Headgear"}>
      {headgears.loading === "pending" && <Loading>Loading</Loading>}
      {headgears.loading === "succeeded" && (
        // @ts-ignore
        <EditHeadgearList headgears={headgears.data} />
      )}
    </EditItemModal>
  );
};

export default EditHeadgearrModal;
