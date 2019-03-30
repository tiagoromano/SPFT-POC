window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaPlanningVacation = window.blockly.js.blockly.TelaPlanningVacation || {};

/**
 * TelaPlanningVacation
 */
window.blockly.js.blockly.TelaPlanningVacation.obterUsuariosSelecionados = function() {
 var item, event, x;
  item = this.cronapi.util.executeJavascriptReturn('$(\'#cron-crn-enterprise-combobox-multiple-675758\').data(\'kendoMultiSelect\').value()');
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.recarregarGrafico = function() {
 var item, event, x;
  this.cronapi.util.executeJavascriptNoReturn('renderChart()');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.abrirModalHistorico = function(event) {
 var item, x;
  if (event == 'success') {
    if (this.cronapi.util.executeJavascriptReturn('Historico.data.length') != 0) {
      this.cronapi.screen.showModal("modalHistorico");
    } else {
      this.cronapi.screen.notify('info','Não existem registros disponíveis para o registro selecionado.');
    }
  } else if (event == 'canceled') {
    this.cronapi.screen.notify('info','Não foi possível obter os registros. Por favor tente novamente.');
  } else {
    this.cronapi.util.executeJavascriptNoReturn('let that = this;\nHistorico.fetch({$inlinecount: \"allpages\", $format: \"json\", $top: \"100\"}, {\nsuccess: function() {\n    that.blockly.js.blockly.TelaPlanningVacation.abrirModalHistorico(\'succe' +
     'ss\')\n},\ncanceled: function() {\n    that.blockly.js.blockly.TelaPlanningVacation.abrirModalHistorico(\'canceled\')\n}}, false)');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.fecharModalHistorico = function() {
 var item, event, x;
  this.cronapi.screen.hideModal("modalHistorico");
}
