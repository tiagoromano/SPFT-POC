window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaRequestVacationDetail = window.blockly.js.blockly.TelaRequestVacationDetail || {};

/**
 * TelaRequestVacationDetail
 */
window.blockly.js.blockly.TelaRequestVacationDetail.SetarParametrosIniciais = function(dividirFerias, abonoPecuniario, primeiraParcelaDecimoTerceiro) {
 var item;
  if (dividirFerias == 'no') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.hideComponent("trPeriodo2");
    this.cronapi.screen.hideComponent("trPeriodo3");
    this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial"));
    this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '30');
    this.cronapi.util.executeJavascriptNoReturn('$(\'[ng-model=\"vars.tr1QtdDias\"]\').data(\"kendoComboBox\").enable(false);');
    this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", this.cronapi.dateTime.incDay(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")), 30));
  } else if (dividirFerias == '2per') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.showComponent("trPeriodo2");
    this.cronapi.screen.hideComponent("trPeriodo3");
  } else if (dividirFerias == '3per') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.showComponent("trPeriodo2");
    this.cronapi.screen.showComponent("trPeriodo3");
  }
}
