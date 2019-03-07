<%-- 
    Document   : index
    Created on : 05-03-2019, 12:06:09
    Author     : Shevitar
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
    <div id="IndexImages" >
        <h3>Here are some of our <em>most popular cupcakes</em></h3>
        <div class="col-md-1 col-md-offset-4">
            <img src="images/cupcake.jpeg" height="125" width="125" alt="fail to load 1"/>
            <p>Unicorn (Sprinkles)</p>
        </div>
        <div class="col-md-1">
            <img src="images/cupcake2.jpg" height="125" width="125" alt="fail to load 2"/>
            <p>Unicorn (Syrup)</p>
        </div>
        <div class="col-md-1">
            <img src="images/cupcake3.jpg" height="125" width="125" alt="fail to load 3"/>
            <p>Double chocolate</p>
        </div>
        <div class="col-md-1">
            <img src="images/cupcake4.jpeg" height="125" width="125" alt="fail to load 4"/>
            <p>Strawberry/Vanilla</p>
        </div>
    </div>
    <div id ="IndexText" class=" col-md-4 col-md-offset-4">

        <h4>Current cupcake options</h4>
    </div>
    <div id="IndexTableTopStyle" class=" col-md-1 col-md-offset-5">
        <table class="table-condensed">
            <tr class=" padding">
                <th>
                    Cupcake tops
                </th>

            </tr>

        <%
            for (int i = 0; i < allTops.size(); i++)
            {%>
        <tr>
            <% String topName = allTops.get(i).getTopName();
                    int topID = allTops.get(i).getTopID();
                    out.print("<td> #" + topID + " " + topName + "</td>");
                }%></tr>
    </table>
</div>

<div id="IndexTableBottomStyle" class=" col-md-1"> <!--col-md-offset-1-->
    <table class="table-condensed">
        <tr>
            <th>
                Cupcake bottoms
            </th>
        </tr>
        <%  for (int j = 0; j < allBottoms.size(); j++)
            {%><tr><%
                        String bottomName = allBottoms.get(j).getBottomName();
                        int bottomID = allBottoms.get(j).getBottomID();
                        out.print("<td> #" + bottomID + " " + bottomName + "</td>");
                    }%></tr>
        </tr>
    </table>
</div>

<jsp:include page='jsp/Footer.jsp'></jsp:include>