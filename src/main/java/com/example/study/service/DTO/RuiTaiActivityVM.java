package com.example.study.service.DTO;

import io.swagger.annotations.ApiModelProperty;


/**
 * @program: ao-campaign-sales
 * @description:
 * @author: WangJJ
 * @create: 2020-10-21 11:18
 **/
public class RuiTaiActivityVM {

        @ApiModelProperty(value = "是否包含门店(默认否)")
        private boolean rspIncludeStores;

        @ApiModelProperty(value = "开始时间(年-月-日)")
        private String rspStartDate;

        @ApiModelProperty(value = "结束时间(年-月-日)")
        private String rspStopDate;

        @ApiModelProperty(value = "页码(默认1)")
        private int rspPageIndex;

        @ApiModelProperty(value = "行码(默认50)")
        private int rspPageSize;

        public boolean isRspIncludeStores() {
            return rspIncludeStores;
        }

        public void setRspIncludeStores(boolean rspIncludeStores) {
            this.rspIncludeStores = rspIncludeStores;
        }

        public String getRspStartDate() {
            return rspStartDate;
        }

        public void setRspStartDate(String rspStartDate) {
            this.rspStartDate = rspStartDate;
        }

        public String getRspStopDate() {
            return rspStopDate;
        }

        public void setRspStopDate(String rspStopDate) {
            this.rspStopDate = rspStopDate;
        }

        public int getRspPageIndex() {
            return rspPageIndex;
        }

        public void setRspPageIndex(int rspPageIndex) {
            this.rspPageIndex = rspPageIndex;
        }

        public int getRspPageSize() {
            return rspPageSize;
        }

        public void setRspPageSize(int rspPageSize) {
            this.rspPageSize = rspPageSize;
        }

        @Override
        public String toString() {
            return "RuiTaiActivityVM{" +
                "rspIncludeStores=" + rspIncludeStores +
                ", rspStartDate=" + rspStartDate +
                ", rspStopDate=" + rspStopDate +
                ", rspPageIndex=" + rspPageIndex +
                ", rspPageSize=" + rspPageSize +
                '}';
        }
}
