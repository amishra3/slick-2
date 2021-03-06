/*
 * Copyright 2016 Chris Millar
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.millr.slick.components.common;

import java.util.Calendar;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.millr.slick.services.SettingsService;
import org.millr.slick.services.settings.AnalyticsService;
import org.millr.slick.services.settings.CommentService;
import org.millr.slick.utils.WCMUse;

/**
 * Sightly component to get System Settings such as blog name.
 */
public class Settings extends WCMUse {

    private SlingScriptHelper scriptHelper;

    private Resource resource;

    private String blogName;
    
    private String blogDescription;
    
    private String analyticsScript;
    
    private String analyticsServiceName;
    
    private String analyticsHeadScript;
    
    private String analyticsFootScript;
    
    private String analyticsReportSuite;
    
    private String analyticsTwitterUsername;
    
    private String analyticsFacebookAppId;
    
    private String commentDefaultStatus;
    
    private String commentSiteKey;
    
    private String commentSecretKey;
    
    private String headerImage;
    
    private String accentColor;

    private boolean useDispatcher;
    
    private boolean enableComments;
    
    private int currentYear;

    @Override
    public void activate() {
        scriptHelper = getSlingScriptHelper();
        resource = getResource();

        SettingsService settingsService = scriptHelper.getService(SettingsService.class);
        
        AnalyticsService analyticsService = scriptHelper.getService(AnalyticsService.class);
        
        CommentService commentService = scriptHelper.getService(CommentService.class);

        if (settingsService != null) {
            blogName = settingsService.getBlogName();
            blogDescription = settingsService.getBlogDescription();
            analyticsScript = settingsService.getAnalyticsScript();
            useDispatcher = settingsService.getUseDispatcher();
            enableComments = settingsService.getEnableComments();
            headerImage = settingsService.getDefaultHeaderImage();
            accentColor = settingsService.getAccentColor();
            enableComments = settingsService.getEnableComments();
        }
        
        if (analyticsService != null) {
            analyticsServiceName = analyticsService.getAnalyticsServiceName();
            analyticsHeadScript = analyticsService.getAnalyticsHeadScript();
            analyticsFootScript = analyticsService.getAnalyticsFootScript();
            analyticsReportSuite = analyticsService.getAnalyticsReportSuite();
            analyticsTwitterUsername = analyticsService.getAnalyticsTwitterUsername();
            analyticsFacebookAppId = analyticsService.getAnalyticsFacebookAppId();
        }
        
        if(commentService != null) {
            commentDefaultStatus = commentService.getCommentsDefaultStatus();
            commentSiteKey = commentService.getCommentsReCapchtaSiteKey();
            commentSecretKey = commentService.getCommentsReCapchtaSecretKey();
        }
    }

    public String getBlogName() {
        return blogName;
    }
    
    public String getBlogDescription() {
        return blogDescription;
    }
    
    public String getAnalyticsScript() {
        return analyticsScript;
    }
    
    public String getAnalyticsServiceName() {
        return analyticsServiceName;
    }
    
    public String getAnalyticsHeadScript() {
        return analyticsHeadScript;
    }
    
    public String getAnalyticsFootScript() {
        return analyticsFootScript;
    }
    
    public String getAnalyticsReportSuite() {
        return analyticsReportSuite;
    }
    
    public String getAnalyticsTwitterUsername() {
        return analyticsTwitterUsername;
    }
    
    public String getAnalyticsFacebookAppId() {
        return analyticsFacebookAppId;
    }
    
    public String getCommentDefaultStatus() {
        return commentDefaultStatus;
    }
    
    public String getCommentSiteKey() {
        return commentSiteKey;
    }
    
    public String getCommentSecretKey() {
        return commentSecretKey;
    }
    
    public String getHeaderImage() {
        return headerImage;
    }
    
    public String getAccentColor() {
        return accentColor;
    }

    public boolean getUseDispatcher() {
        return useDispatcher;
    }
    
    public boolean getEnableComments() {
        return enableComments;
    }
    
    public int getCurrentDate() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}