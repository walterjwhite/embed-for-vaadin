/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bsb.common.vaadin.embed.component;

import com.bsb.common.vaadin.embed.EmbedVaadinConfig;

import java.util.Properties;

/**
 * Configuration for an embedded server showing a component.
 * <p/>
 * This extends the {@link EmbedVaadinConfig} and is configured in the same way.
 * The properties file may contain any of the properties documented on {@link EmbedVaadinConfig} and
 * additionally:
 * <ul>
 * <li><tt>vaadin.theme</tt>: to specify the theme to use for the vaadin application</li>
 * </ul>
 *
 * @author Wouter Coekaerts
 */
public final class EmbedComponentConfig extends EmbedVaadinConfig {

    private static final long serialVersionUID = -1058773155435290313L;

    /**
     * The default theme if none is set.
     */
    public static final String DEFAULT_THEME = "reindeer";

    private String theme;

    protected EmbedComponentConfig(Properties properties) {
        super(properties);
        theme = properties.getProperty("vaadin.theme", DEFAULT_THEME);
    }

    protected EmbedComponentConfig(EmbedComponentConfig clone) {
        super(clone);
        theme = clone.theme;
    }

    /**
     * Returns the vaadin theme to use for the application. Only taken into account
     * when a wrapper application is created for a component.
     *
     * @return the theme to use
     * @see #DEFAULT_THEME
     */
    public String getTheme() {
        return theme;
    }

    void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Creates a new instance with the default settings, i.e. does not attempt
     * to load customized settings from the {@link #CONFIG_LOCATION config location}.
     *
     * @return a new instance with the default settings
     */
    public static EmbedComponentConfig defaultConfig() {
        return new EmbedComponentConfig(new Properties());
    }
}
