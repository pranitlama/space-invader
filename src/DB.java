    import java.sql.*;

    public class DB {

        int highscore;
        DB(int score) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/space_invader";

            Connection conn = DriverManager.getConnection(url,"root","");

            System.out.println("connection success");

//        insert data to database
            Statement statement = conn.createStatement();
            if (score > highscore){
//                int enterSet = statement.executeUpdate("INSERT INTO score (highscore) values ('score')");


                PreparedStatement st = conn.prepareStatement("INSERT INTO score(highscore) VALUES (?)");

                st.setInt(1, score);

                int res = st.executeUpdate();

                if (res > 0) {
                    System.out.println("hello");
                }
            }


            ResultSet resultSet = statement.executeQuery(" (SELECT max(highscore) as highscore from score)");
            while (resultSet.next()) {
                highscore = resultSet.getInt("highscore");
            }

        }
        public int getHighscore() {
            System.out.println(highscore);
            return this.highscore;
        }



    }
