package com.example.chenshuyu.dreamer.entity;

import java.io.Serializable;
import java.util.List;

public class Dreamer {

    /**
     * error_code : 0
     * data : [{"title":"自己喝水","desc":"梦见自己喝水，水是生命的源泉，梦中出现此物往往暗示着人的健康状况。喝清水意味着身体强壮结实;喝非常甜的饮品则意味着身体会遭受疾病的困扰。","list":["梦见自己喝水，水是生命的源泉，梦中出现此物往往暗示着人的健康状况。喝清水意味着身体强壮结实;喝非常甜的饮品则意味着身体会遭受疾病的困扰。","梦见自己喝清水或干净水，会身体强壮。","梦见喝脏水，身体会有病。","梦见喝凉水或甜水，要去旅行并能得到一笔钱。","梦见喝非常甜的饮料，则意味着疾病的困扰。","梦见喝热水，会病魔缠身。","旅游者梦见喝水，途中会遇到很多困难。","商人梦见喝水，生意会极不景气。","孕妇梦见喝水，将来会难产。","梦见自己大口大口地喝海水，暗示久久渴望实现的愿望将会变成现实。"]},{"title":"喝水","desc":"喝水主健康。水是生命的源泉，喝水在梦中代表了人的健康状况。","list":["喝水主健康。水是生命的源泉，喝水在梦中代表了人的健康状况。","梦见自己喝清水，会身体强壮。","梦见喝非常甜的饮料，则意味着疾病的困扰。","梦见喝脏水，预示将遭遇不幸，地位和钱财受到损失。","梦见喝凉水，预示会通过艰苦奋斗，得到成绩和荣誉。","梦见自己喝井水，如果井水清澈，预示会发财。如果井水很污浊，则预示你会遭受挫折。","出门在外的打工者或旅行者梦见自己喝井水，表示对家乡的思念，预示可能会回家。","梦见喝山里的泉水，象征心态平和，自由自在，无忧无虑。","旅游者梦见喝水，途中会遇到很多困难。","商人梦见喝水，生意会极不景气。","孕妇梦见喝水，将来会难产。","梦见在水里行走，会得到神的帮助。","犯人梦见在水里行走，很快能自由。","病人梦见在水里走，不久身体会健康。"]},{"title":"喝水 饮水","desc":"梦见自己喝清水，暗示身体健康。","list":["梦见自己喝清水，暗示身体健康。","梦见喝脏水，预示将遭遇不幸，地位和钱财受到损失。","梦见喝凉水，预示会通过艰苦奋斗，得到成绩和荣誉。","梦见自己喝江河、湖泊的水，表示生活舒适，身体健康，无忧无虑，有福气。","梦见喝小沟小渠的水，则表示你会遇到麻烦，可能会被卷入官司。病人做这样的梦，暗示病情加重。商人做这样的梦，预示会亏损，或生意上麻烦不断。","梦见喝山里的泉水，象征心态平和，自由自在，无忧无虑。","梦见自己喝井水，如果井水清澈，预示会发财。如果井水很污浊，则预示你会遭受挫折。出门在外的打工者或旅行者梦见自己喝井水，表示对家乡的思念，预示可能会回家。梦见别人递给你井水，预示你可能会从别人那里收到家乡的消息。"]}]
     * reason : success
     */

    private int error_code;
    private String reason;
    private List<DataBean> data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * title : 自己喝水
         * desc : 梦见自己喝水，水是生命的源泉，梦中出现此物往往暗示着人的健康状况。喝清水意味着身体强壮结实;喝非常甜的饮品则意味着身体会遭受疾病的困扰。
         * list : ["梦见自己喝水，水是生命的源泉，梦中出现此物往往暗示着人的健康状况。喝清水意味着身体强壮结实;喝非常甜的饮品则意味着身体会遭受疾病的困扰。","梦见自己喝清水或干净水，会身体强壮。","梦见喝脏水，身体会有病。","梦见喝凉水或甜水，要去旅行并能得到一笔钱。","梦见喝非常甜的饮料，则意味着疾病的困扰。","梦见喝热水，会病魔缠身。","旅游者梦见喝水，途中会遇到很多困难。","商人梦见喝水，生意会极不景气。","孕妇梦见喝水，将来会难产。","梦见自己大口大口地喝海水，暗示久久渴望实现的愿望将会变成现实。"]
         */

        private String title;
        private String desc;
        private List<String> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }
}
