<%
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@include file="../init.jsp" %>

<portlet:defineObjects />
<liferay-ui:success key="success" message="Greeting saved successfully!"/>

<liferay-portlet:actionURL name="addOrganization" var="addOrganizationURL"/>

<aui:form action="${addOrganizationURL}" method="post" id="aform" name="aform">
    <aui:fieldset label="addOrganizationURL">
        <aui:input type="text" name="name" label="Name" cols="60"/>
        <aui:input type="text" name="address" label="Address" size="60"/>
    </aui:fieldset>
    <aui:button type="submit" value="addOrganization"/>
</aui:form>


<aui:fieldset label="Titolo">
    <aui:layout>
        <aui:column columnWidth="70" cssClass="detail-column detail-column-first">
            <aui:input type="text" name="codCliente" label="Codice Cliente" cssClass="input-small" disabled="true" inlineField="true"/>
            <aui:input type="text" name="cliente" label="Cliente" cssClass="input-xxlarge" inlineField="true"/>
            <aui:input type="text" name="destinazione" label="Destinazione diversa" style="width: 85%" />
            <aui:input id="data1" type="text" name="dataOrdine"   label="Data Ordine"     inlineField="true" />
            <aui:input type="text" name="dataConsegna" label="Data Consegna"   inlineField="true" />
            <%--aui:input type="text" name="totPedane"    label="Tot. Pedane"     inlineField="true" cssClass="input-small"/>
            <aui:input type="text" name="Tot. Pesate"  label="Tot. Pesate"     inlineField="true" cssClass="input-small" /--%>
        </aui:column>
        <aui:column columnWidth="20" >
            <aui:field-wrapper label="Ordine Finito"  >
                <aui:input type="radio" name="completoSi" label="Si" inlineLabel="true" checked="true" inlineField="true"/>
                <aui:input type="radio" name="completoNo" label="No" inlineLabel="true" inlineField="true"/>
            </aui:field-wrapper>
            <aui:input type="text" name="nDoc"    label="N. Documento"  />
            <aui:input type="text" name="recProt" label="Rec Protocollo"/>
        </aui:column>
    </aui:layout>
</aui:fieldset>
<aui:field-wrapper >
    <div class="btn-toolbar">
        <div class="btn-group">
            <aui:a id="btnAdd" cssClass="btn" href="#"><i class="icon-plus"></i>Aggiungi</aui:a>
            <aui:a id="btnRemove" cssClass="btn" href="#"><i class="icon-trash"></i>Rimuovi</aui:a>
            </div>
        </div>
</aui:field-wrapper>
<aui:fieldset id="myDataTable"/>


<script>
    YUI({lang: 'it'}).use(
            'aui-datepicker',
            function (Y) {
                var datepicker = new Y.DatePicker(
                        {
                            trigger: '#<portlet:namespace />data1',
                            mask: '%d/%m/%y',
                            popover: {
                                position: 'top',
                                toolbars: {
                                    header: [[
                                            {
                                                icon: 'icon-trash',
                                                label: 'Clear',
                                                on: {
                                                    click: function () {
                                                        datepicker.clearSelection();
                                                    }
                                                }
                                            }
                                        ]]
                                },
                                zIndex: 1
                            },
                            on: {
                                selectionChange: function (event) {
                                    console.log(event.newSelection);
                                }
                            }
                        }
                );
            }
    );

    YUI().use("datatable-sort", "datatable-scroll", "datatable-mutable",
            function (Y) {
                var columns = [
                    {
                        key: 'name',
                        label: 'Nome'
                    },
                    {
                        key: 'address',
                        label: 'Indirizzo'
                    },
                    {
                        key: 'city',
                        label: 'Città'
                    },
                    {
                        key: 'state',
                        label: 'Stato'
                    }];

                var data = [
                    {address: '1236 Some Street', city: 'San Francisco', name: 'John A. Smith', state: 'CA'},
                    {address: '3271 Another Ave', city: 'New York', name: 'Joan B. Jones', state: 'NY'},
                    {address: '9996 Random Road', city: 'Los Angeles', name: 'Bob C. Uncle', state: 'CA'},
                    {address: '1623 Some Street', city: 'San Francisco', name: 'John D. Smith', state: 'CA'},
                    {address: '9899 Random Road', city: 'Los Angeles', name: 'Bob F. Uncle', state: 'CA'}
                ];


                var table = new Y.DataTable(
                        {
                            columnset: columns,
                            recordset: data,
                            scrollable: 'y',
                            height: '250px',
                            sortable: ['name', 'city'],
                        }
                ).render('#<portlet:namespace />myDataTable');

                Y.one("#<portlet:namespace />btnAdd").on("click", function () {
                    alert("PIPPO");
                    var new_data = {address: 'AAAAAAAAA', city: 'BBBBBBB', name: 'CCCCCCCCC', state: 'IT'};
                    //     table.get('data').add(new_data);   // this works fine!
                    table.addRow(new_data);
                    //      table.syncUI();        // don't need this ... unless silent:true is set
                });
            }

    ); //http://jsfiddle.net/emooney/jHnXD/1/

</script>