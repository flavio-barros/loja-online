/**
 * 
 */

$(document).ready(function () {
    var tabela_fabricante = $(".tabela-fabricante").DataTable({
        "language": {
            "decimal": "",
            "emptyTable": "Não existem fabricantes cadastrados",
            "info": "Mostrando _START_ - _END_ de _TOTAL_ fabricantes",
            "infoEmpty": "Mostrando 0 - 0 de 0 fabricantes",
            "infoFiltered": "(filtrado de um total de _MAX_ fabricantes)",
            "infoPostFix": "",
            "thousands": ".",
            "lengthMenu": "Mostrar _MENU_ fabricantes",
            "loadingRecords": "Carregando...",
            "processing": "Processando...",
            "search": "Pesquisar:",
            "zeroRecords": "Não existem fabricantes que satisfazem a pesquisa",
            "paginate": {
                "first": "Primeira",
                "last": "Última",
                "next": "Próxima",
                "previous": "Anterior"
            },
            "aria": {
                "sortAscending": ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
        },
        "dom": '<"row justify-content-between" lpf>ti',
        "columnDefs": [{ orderable: false, targets: [1, 2] }],
        "lengthMenu": [5, 10, 20, 50]
    });
});