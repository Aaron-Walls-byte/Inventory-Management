package com.example.myapplication;

public class Items{
        private int id;
        private String item;
        private int count;

        public Items(){
            super();
        }

        public Items(int id){
            super();
            this.id = id;
        }
        public Items(int id, String item) {
            super();
            this.id = id;
            this.item = item;
        }
        public Items(int id, String item, int count ) {
            super();
            this.id = id;
            this.item = item;
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
        public String display(){
            return " " + item + "          " + count + " ";
        }
}

