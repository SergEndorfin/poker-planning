package com.rgnrk.pokerplanning.constant;

public final class TemplateConstant {
    //Attributes
    public static final String SUCCESS_MSG_ATR = "successMessage";
    public static final String ERROR_MSG_ATR = "errorMessage";

    public static final String LOGGED_IN_USER_ATR = "loggedInUser";
    public static final String SESSION_CREATED_MSG_ATR = "sessionCreatedMsg";
    public static final String SESSION_ID_ATR = "sessionId";
    public static final String PLANING_SESSION_ATR = "planingSession";
    public static final String INVITE_URL_ATR = "inviteUrl";
    public static final String PLANNING_SESSION_CURRENT_USER_ATR = "planningSessionCurrentUser";
    public static final String USER_STORY_ID_ATR = "userStoryId";

    //Values
    public static final String SUCCESS_MSG = "Registration successful! Please log in.";
    public static final String UNIQUE_EMAIL_ERROR_MSG = "User not registered. Email should be unique.";
    public static final String UNIQUE_USERNAME_ERROR_MSG = "Username should be unique. Try new one.";
    public static final String SESSION_CREATED_MSG = "Session created successfully. Now you can join it.";

    private TemplateConstant() {
    }
}
