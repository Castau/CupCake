<%-- 
    Document   : index
    Created on : 05-03-2019, 12:06:09
    Author     : Asger
--%>

<%@page import="Data.Model_CupCake"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Mapper_CupCake"%>
<%
    Mapper_CupCake mc = new Mapper_CupCake();
    //ArrayList<Model_CupCake> allCupcakes = mc.getAllCupCakes();
    ArrayList<Model_CupCake.Cupcake_Top> allTops = mc.getAllCupcakeTops();
    ArrayList<Model_CupCake.Cupcake_Bottom> allBottoms = mc.getAllCupcakeBottoms();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='jsp/Header.jsp'></jsp:include>
    <h2>Please log in or register to continue</h2>
<jsp:include page='jsp/NavigationBar.jsp'></jsp:include>
    
<div id="index">
        <div class="row center">
            <div>
                <h3>
                    <span class="inline-block">Here are some of our </span>
                    <span class="inline-block"><em>most popular cupcakes</em> </span>
                </h3>
                <br/>
            </div>
        </div>
        <div class="row center">
            <div class="IndexImages">
                <div class="inline-block">
                    <div class="inline-block ImagesMargin" >
                        <img src="images/cupcake.jpeg" height="125" width="125" alt="fail to load 1"/>
                        <p>Unicorn (Sprinkles)</p>
                    </div>

                    <div class="inline-block ImagesMargin">
                        <img src="images/cupcake2.jpg" height="125" width="125" alt="fail to load 2"/>
                        <p>Unicorn (Syrup)</p>
                    </div>
                </div>

                <div class="inline-block">
                    <div class="inline-block ImagesMargin">
                        <img src="images/cupcake3.jpg" height="125" width="125" alt="fail to load 3"/>
                        <p>Double chocolate</p>
                    </div>

                    <div class="inline-block ImagesMargin">
                        <img src="images/cupcake4.jpeg" height="125" width="125" alt="fail to load 4"/>
                        <p>Strawberry/Vanilla</p>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <div class="row center">
            <div>
                <h4>Current cupcake options</h4>
            </div>
        </div>
        <br/>
        <div id="IndexTableTopStyle" class="col-md-2 col-md-offset-4 col-sm-2 col-sm-offset-4 col-xs-3 col-xs-offset-3">
            <table class="table-condensed">
                <tr>
                    <th>
                        Cupcake tops
                    </th>

                </tr>

            <%
                for (int i = 0; i < allTops.size(); i++) {%>
            <tr>
                <% String topName = allTops.get(i).getTopName();
                        int topID = allTops.get(i).getTopID();
                        out.print("<td> #" + topID + " " + topName + "</td>");
                    }%></tr>
        </table>
    </div>

    <div id="IndexTableBottomStyle" class="col-md-2 col-md-offset-1 col-sm-2 col-xs-3"> <!--col-md-offset-1-->
        <table class="table-condensed">
            <tr>
                <th>
                    Cupcake bottoms
                </th>
            </tr>
            <%  for (int j = 0; j < allBottoms.size(); j++) {%><tr><%
                    String bottomName = allBottoms.get(j).getBottomName();
                    int bottomID = allBottoms.get(j).getBottomID();
                    out.print("<td> #" + bottomID + " " + bottomName + "</td>");
                }%></tr>
            </tr>
        </table>
    </div>
</div>
<jsp:include page='jsp/Footer.jsp'></jsp:include>