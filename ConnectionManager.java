package Topic_4.hw_8;

/**
 * Task_1
 * @author Holopura Anna
 */

public class ConnectionManager
{
    private static final int MAX_CONNECTIONS = 5;
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static int currentConnectionIndex = 0;

    public static Connection getConnection()
    {
        if (currentConnectionIndex < MAX_CONNECTIONS)
        {
            if (connections[currentConnectionIndex] == null)
            {
                connections[currentConnectionIndex] = new Connection(currentConnectionIndex);
            }
            return connections[currentConnectionIndex++];
        }
        else
        {
            System.out.println("No more available connections. Terminating.");
            System.exit(0);
            return null;
        }
    }

    public static void releaseConnection(Connection connection) { }

    public static class Connection
    {
        private int id;

        private Connection(int id) { this.id = id; }

        public void executeQuery(String query)
        {
            System.out.println("Executing query: " + query + " on connection " + id);
        }
    }

    public static void main(String[] args)
    {
        Connection conn1 = ConnectionManager.getConnection();
        conn1.executeQuery("SELECT * FROM table1");

        Connection conn2 = ConnectionManager.getConnection();
        conn2.executeQuery("UPDATE table2 SET column1 = 'value'");

        ConnectionManager.releaseConnection(conn1);
        ConnectionManager.releaseConnection(conn2);
    }
}