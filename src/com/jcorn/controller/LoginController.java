package com.jcorn.controller;

import com.jcorn.helper.HTTPRequester;
import com.jcorn.helper.WebApiLinks;

/**
 * JocolateManager
 *
 * @author Markus Petritz
 * @version 1.0.0
 * @see http://petritzdesigns.com
 */
public class LoginController {

    public String login(String username, String password) throws Exception {
        String url = WebApiLinks.getLoginApiLink(username, password);
        return HTTPRequester.getContentFromUrl(url);
    }
}
