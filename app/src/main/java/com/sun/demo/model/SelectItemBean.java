package com.sun.demo.model;

/**
 * @author Harper
 * @date 2021/11/24
 * note:
 */
public class SelectItemBean {

    public static class Multi{
        private int selectIndex;


        public Multi(int selectIndex) {
            this.selectIndex = selectIndex;
        }

        public int getSelectIndex() {
            return selectIndex;
        }

        public void setSelectIndex(int selectIndex) {
            this.selectIndex = selectIndex;
        }
    }

    public static class Single{

        private boolean isSelect;

        public Single(boolean isSelect) {
            this.isSelect = isSelect;
        }

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }
    }

}
