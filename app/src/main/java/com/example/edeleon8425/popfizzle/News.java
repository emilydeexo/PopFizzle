package com.example.edeleon8425.popfizzle;

/**
 * Created by edeleon8425 on 1/2/2018.
 */

public class News {
    //variables
        int id;
        String nname;
        String ngenre;

        // Constructor with two parameters name and password
        public News(String nname,String ngenre)
        {
            this.nname=nname;
            this.ngenre=ngenre;
        }

        //getting id
        public int getId() {
            return id;
        }
        //setting id
        public void setId(int id) {
            this.id = id;
        }

        //getting name
        public String getName() {
            return nname;
        }
        //setting name
        public void setName(String nname) {
            this.nname = nname;
        }

        //getting password
        public String getGenre() {
            return ngenre;
        }
        //setting password
        public void setGenre(String ngenre) {
            this.ngenre = ngenre;
        }
}
