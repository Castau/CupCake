/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Mapper_CupCake;
import Data.Model_CupCake;
import java.sql.SQLException;

/**
 *
 * @author Shevitar
 */
public class Controller_CupCake
{
    public Model_CupCake getCupCake(int idTop, int idBottom) throws SQLException
    {
        Mapper_CupCake mc = new Mapper_CupCake();
        return mc.getCupCake(idTop, idTop);
    }
}
