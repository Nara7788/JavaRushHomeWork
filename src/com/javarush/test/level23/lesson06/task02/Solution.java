package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_NA);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_NA, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_NA);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_NA, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_BAN);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_BAN, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCESS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCESS_DENIED, cause);
        }
    }

    public static final class Constants {
        public static final String SERVER_NA = "Server is not accessible for now.";
        public static final String USER_NA = "User is not authorized.";
        public static final String USER_BAN = "User is banned.";
        public static final String ACCESS_DENIED = "Access is denied.";
    }
}

