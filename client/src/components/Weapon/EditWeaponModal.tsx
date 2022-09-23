import { type FC, useEffect } from "react";
import { EditItem as EditItemModal } from "@chia/components/Modal";
import EditWeaponList from "./EditWeaponList";
import { useAppDispatch } from "@chia/hooks/useAppDispatch";
import { useAppSelector } from "@chia/hooks/useAppSelector";
import { getAllWeaponsAsync } from "@chia/store/modules/Weapon/actions";
import { selectAllWeapons } from "@chia/store/modules/Weapon";
import {
  selectActionSheet,
  activeEditWeaponModal,
} from "@chia/store/modules/ActionSheet";
import { Loading } from "@geist-ui/core";
import { useReadLocalStorage } from "usehooks-ts";
import { LocalUser } from "@chia/shared/types";

const EditWeaponModal: FC = () => {
  const dispatch = useAppDispatch();
  const weapons = useAppSelector(selectAllWeapons);
  const actionSheet = useAppSelector(selectActionSheet);
  const userData = useReadLocalStorage<LocalUser>("userData");

  useEffect(() => {
    if (!weapons.data && actionSheet.editWeaponModal.isOpen)
      // @ts-ignore
      dispatch(getAllWeaponsAsync(userData.token));
  }, [actionSheet.editWeaponModal.isOpen]);

  return (
    <EditItemModal
      isOpen={actionSheet.editWeaponModal.isOpen}
      onClose={() => dispatch(activeEditWeaponModal())}
      title={"Weapon"}>
      {weapons.loading === "pending" && <Loading>Loading</Loading>}
      {weapons.loading === "succeeded" && (
        // @ts-ignore
        <EditWeaponList weapons={weapons.data} />
      )}
    </EditItemModal>
  );
};

export default EditWeaponModal;
