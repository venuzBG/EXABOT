
import DataAccess.DTO.SexoDTO;
import BusinessLogic.Entities.SexoBL;
import DataAccess.SexoDAO;



public class App {
    public static void main(String[] args) throws Exception {
    // testing: DAO
        // try {
        //     SexoDAO sDao = new SexoDAO();
        //     for(SexoDTO s : sDao.readAll())
        //         System.out.println(s.toString());
        // } catch (Exception e) {
        //     System.out.println(e.toString());
        // }
    //testing: BL
        try {
            SexoBL sBL = new SexoBL();
            for(SexoDTO s : sBL.getALL())
                System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
