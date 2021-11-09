package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum;

public class EnumList {
    public enum Action{
        //phone, webLink,message, block, share, operator

        PHONE("phone",1), WEBLINK("webLink",2), MESSAGE("message",3),
        BLOCK("block",4), SHARE("share",5), OPERATOR("operator",6);
        private String action;
        private int actionNum;

        private Action(String action, int actionNum){
            this.action = action;
            this.actionNum = actionNum;
        }

        public String getAction(){
            return action;
        }

        public int getActionNum(){
            return actionNum;
        }
    }

    public enum Currency{
        WON("won");
        private String currency;

        private Currency(String currency){
            this.currency = currency;
        }

        public String getCurrency(){
            return currency;
        }

    }

    public enum ImageRatio{
        ONETOONE(800,800),TWOTOONE(800,400);
        private int width;
        private int height;

        private ImageRatio(int width, int height){
            this.width = width;
            this.height = height;
        }

        public int getWidth(){
            return width;
        }

        public int getHeight(){
            return height;
        }

    }

    public enum ItemAlignment{
        LEFT("left"), RIGHT("right");
        private String alignment;

        private ItemAlignment(String alignment){
            this.alignment = alignment;
        }

        public String getAlignment(){
            return alignment;
        }

    }

    public enum ButtonLayout{
        VERTICAL("vertical"), HORIZONTAL("horizontal");
        private String layout;

        private ButtonLayout(String layout){
            this.layout = layout;
        }

        public String getLayout(){
            return layout;
        }

    }

    public enum CarouselType{
        BASIC("basicCard"), COMMERCE("commerceCard"),
        LIST("listCard"),ITEM("itemCard");
        private String type;

        private CarouselType(String type){
            this.type = type;
        }

        public String getType(){
            return type;
        }
    }
}
