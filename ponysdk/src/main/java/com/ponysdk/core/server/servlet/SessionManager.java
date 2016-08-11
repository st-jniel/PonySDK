/*
 * Copyright (c) 2011 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *  Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *  Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ponysdk.core.server.servlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import com.ponysdk.core.server.application.Application;

public class SessionManager {

    private static final SessionManager INSTANCE = new SessionManager();

    private final Map<String, Application> applicationsBySessionID = new ConcurrentHashMap<>();

    private final List<ApplicationListener> listeners = new ArrayList<>();

    public static SessionManager get() {
        return INSTANCE;
    }

    public Collection<Application> getApplications() {
        return new ArrayList<>(applicationsBySessionID.values());
    }

    public Application getApplication(final HttpSession session) {
        if (session == null) return null;
        return getApplication(session.getId());
    }

    public Application getApplication(final String sessionID) {
        return applicationsBySessionID.get(sessionID);
    }

    public void registerApplication(final Application application) {
        applicationsBySessionID.put(application.getSession().getId(), application);
        listeners.forEach(listener -> listener.onApplicationCreated(application));
    }

    public void unregisterApplication(final Application application) {
        applicationsBySessionID.remove(application.getSession().getId());
        listeners.forEach(listener -> listener.onApplicationDestroyed(application));
    }

    public void addApplicationListener(final ApplicationListener listener) {
        listeners.add(listener);
    }

}
