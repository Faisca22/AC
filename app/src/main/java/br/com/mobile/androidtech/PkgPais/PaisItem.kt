package br.com.mobile.androidtech.PkgPais

data class PaisItem(
    var area: Area,
    var governo: Governo,
    var historico: String,
    var id: Id,
    var linguas: List<Lingua>,
    var localizacao: Localizacao,
    var nome: Nome
    //var unidades-monetarias: List<UnidadesMonetaria>
)