package utils;

public class Constants {
    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK = 6;
        public static final int ATTACK_JUMP_1 = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int GetSpriteAmount(int player_action) {
            return switch (player_action) {
                case RUNNING -> 6;
                case IDLE -> 5;
                case GROUND -> 2;
                case HIT -> 4;
                case ATTACK, ATTACK_JUMP_1, ATTACK_JUMP_2, JUMP -> 3;
                default -> 1;
            };
        }


    }
}
