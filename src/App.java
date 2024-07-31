
import DataAccess.DTO.SexoDTO;
import DataAccess.SexoDAO;


public class App {
    public static void main(String[] args) throws Exception {
        try {
            SexoDAO sDao = new SexoDAO();
            for(SexoDTO s : sDao.readAll())
                System.out.println(s.toSring());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
