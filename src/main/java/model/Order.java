package model;

import java.util.List;

    public class Order {
        private String id;
        private String costumerId;
        private String tableId;
        private String status; //open/closed
        private List<OrderLine> orderLines;
        private List<OrderAssignment> assignments;

        public Order(String id, String costumerId, String tableId, String status, List<OrderLine> orderLines, List<OrderAssignment> assignments) {
            this.id = id;
            this.costumerId = costumerId;
            this.tableId = tableId;
            this.status = status;
            this.orderLines = orderLines;
            this.assignments = assignments;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCostumerId() {
            return costumerId;
        }

        public void setCostumerId(String costumerId) {
            this.costumerId = costumerId;
        }

        public String getTableId() {
            return tableId;
        }

        public void setTableId(String tableId) {
            this.tableId = tableId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<OrderLine> getOrderLines() {
            return orderLines;
        }

        public void setOrderLines(List<OrderLine> orderLines) {
            this.orderLines = orderLines;
        }

        public List<OrderAssignment> getAssignments() {
            return assignments;
        }

        public void setAssignments(List<OrderAssignment> assignments) {
            this.assignments = assignments;
        }
    }

