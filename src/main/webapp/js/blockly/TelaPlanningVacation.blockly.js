window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaPlanningVacation = window.blockly.js.blockly.TelaPlanningVacation || {};

/**
 * TelaPlanningVacation
 */
window.blockly.js.blockly.TelaPlanningVacation.obterUsuariosSelecionados = function() {
 var item;
  item = this.cronapi.util.executeJavascriptReturn('$(\'#cron-crn-enterprise-combobox-multiple-675758\').data(\'kendoMultiSelect\').value()');
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.changeUserSelectionHandler = function() {
 var item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.recarregarGrafico = function() {
 var item;
  this.cronapi.util.executeJavascriptNoReturn('renderChart()');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaPlanningVacation.initCombo = function() {
 var item;
}
