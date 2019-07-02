/**
 * 
 */

$(document).ready(function () {
    var tabela_produto = $(".tabela-produto").DataTable({
        "language": {
            "decimal": "",
            "emptyTable": "Não existem produtos cadastrados",
            "info": "Mostrando _START_ - _END_ de _TOTAL_ produtos",
            "infoEmpty": "Mostrando 0 - 0 de 0 produtos",
            "infoFiltered": "(filtrado de um total de _MAX_ produtos)",
            "infoPostFix": "",
            "thousands": ".",
            "lengthMenu": "Mostrar _MENU_ produtos",
            "loadingRecords": "Carregando...",
            "processing": "Processando...",
            "search": "Pesquisar:",
            "zeroRecords": "Não existem produtos que satisfazem a pesquisa",
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
        "columnDefs": [{ orderable: false, targets: [2, 3] }],
        "lengthMenu": [5, 10, 20, 50]
    });
});