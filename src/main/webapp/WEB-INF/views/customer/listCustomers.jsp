<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Customers</title>

<link rel="stylesheet" href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
       href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" 
       href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="customerDialog" style="display: none;">
            <%@ include file="customerForm.jsp"%>
        </div>

        <h1>List Of Customers</h1>

        <button class="pure-button pure-button-primary" onclick="addCustomer()">
            <i class="fa fa-plus"></i> Add Customer
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">S.N</th>
                  <th width="12%">Name</th>
                  <th width="12%">Phone</th>
                  <th width="12%">Website</th>
                  <th width="12%"></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${customerList}" var="customer" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${loopCounter.count}" /></td>
                   <td><c:out value="${customer.name}" /></td>
                   <td><c:out value="${customer.phone}" /></td>
                   <td><c:out value="${customer.website}" /></td>
                   <td>
                     <nobr>
                        <button onclick="editCustomer(${customer.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${customer.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this customer?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>
    
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/js-for-listCustomers.js"/>'></script>
</body>
</html> 