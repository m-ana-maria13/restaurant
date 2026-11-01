package model;

import java.util.ArrayList;
import java.util.List;

    public class Order {

        private static int counter=1;
        private String id;
        private String customerId;
        private String tableId;
        private String status; //open/closed
        private List<OrderLine> orderLines;
        private List<OrderAssignment> assignments;
        private Boolean takeAway; // daca e takeaway, atunci nu se mai ocupa masa, ! nu se face delivery, vine clientul

        public Order(String customerId, String tableId, boolean takeAway) {
            this.id = String.valueOf(counter);
            counter++;
            this.customerId = customerId;
            this.tableId = tableId;
            this.status = "open";
            this.takeAway= takeAway;
            this.orderLines = new ArrayList<OrderLine>();
            this.assignments = new ArrayList<OrderAssignment>();

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = this.customerId;
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

        public Boolean getTakeAway() {
            return takeAway;
        }

        public void setTakeAway(Boolean takeAway) {
            this.takeAway = takeAway;
        }
    }

