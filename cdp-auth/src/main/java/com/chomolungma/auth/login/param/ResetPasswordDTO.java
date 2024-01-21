package com.chomolungma.auth.login.param;

import lombok.Data;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: kushu001
 * @Date: 2024/01/20/20:26
 * @Description:
 */
@Data
public class ResetPasswordDTO {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
