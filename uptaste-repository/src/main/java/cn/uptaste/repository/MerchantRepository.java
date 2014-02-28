package cn.uptaste.repository;

import cn.uptaste.model.Merchant;

/**
 * Created by yudeyang on 14-2-22.
 */
public interface MerchantRepository {
    Merchant getMerchantByUsernameAndPassword(String username, String password);

    Merchant getMerchantByUsername(String username);

    void addMerchant(Merchant merchant);
}
