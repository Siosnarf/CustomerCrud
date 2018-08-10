<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="customerForm" commandName="customer" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="Customer Name" />
          </div>
          <div class="pure-control-group">
               <label for="code">Phone</label>
               <form:input path="phone" placeholder="phone" />
          </div>
          <div class="pure-control-group">
              <label for="price">Website</label>
              <form:input path="website" placeholder="website" />
          </div>         

          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>