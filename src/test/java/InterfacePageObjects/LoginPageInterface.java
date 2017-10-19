/*
 * Copyright (c) 2014 - 2017.  Element34 Solutions - All Rights Reserved
 * Unauthorized copying and redistribution of this file or parts thereof,
 * via any medium is strictly prohibited without explicit consent of Element34 Solutions GmbH.
 */

package InterfacePageObjects;

/**
 * Created by gridfusion on 20/09/15.
 */
public interface LoginPageInterface {

    public void enterUserName(String username);
    public void enterPassword(String password);
    public void clickLoginButton();
}
