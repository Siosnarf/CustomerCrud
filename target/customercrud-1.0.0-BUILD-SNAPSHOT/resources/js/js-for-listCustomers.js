function addCustomer() {
       $('#customerDialog').dialog("option", "title", 'Add Customer');
       $('#customerDialog').dialog('open');
}

function editCustomer(id) {

       $.get("get/" + id, function(result) {

              $("#customerDialog").html(result);
              $('#customerDialog').dialog("option", "title", 'Edit Customer');
              $("#customerDialog").dialog('open');
       });
}

function resetDialog(form) {

       form.find("input").val("");
}

$(document).ready(function() {

       $('#customerDialog').dialog({

              autoOpen : false,
              position : 'center',
              modal : true,
              resizable : false,
              width : 440,
              buttons : {
                     "Save" : function() {
                           $('#customerForm').submit();
                     },
                     "Cancel" : function() {
                           $(this).dialog('close');
                     }
              },
              close : function() {

                     resetDialog($('#customerForm'));
                     $(this).dialog('close');
              }
       });
});