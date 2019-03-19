window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaRequestVacationDetail = window.blockly.js.blockly.TelaRequestVacationDetail || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo = function(DataInicial, DataFinal) {
 var item, abonoPecuniario, compDataFinal, compDataInicial, compDias, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  if (this.cronapi.logic.isNullOrEmpty(DataInicial) || this.cronapi.logic.isNullOrEmpty(DataFinal)) {
    item = false;
  } else {
    item = DataInicial >= this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")) && DataFinal <= this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataFinal"));
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.CriarSolicitacao = function() {
 var item, abonoPecuniario, compDataFinal, compDataInicial, compDias, DataFinal, DataInicial, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  if (this.blockly.js.blockly.TelaRequestVacationDetail.ValidarSolicitacao()) {
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.ValidarSolicitacao = function() {
 var item, abonoPecuniario, compDataFinal, compDataInicial, compDias, DataFinal, DataInicial, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  item = true;
  if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.dividirFerias"))) {
    this.cronapi.screen.notify('error','Informe se deseja dividir as férias');
    item = false;
  } else if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.abonoPecuniario"))) {
    this.cronapi.screen.notify('error','Informe se deseja o abono pecuniário');
    item = false;
  } else if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.primParcDecimTerc"))) {
    this.cronapi.screen.notify('error','Informe se deseja receber a 1ª parcela do 13º junto com as férias');
    item = false;
  } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") != 'no' && this.cronapi.screen.getValueOfField("vars.abonoPecuniario") == 'yes') {
    this.cronapi.screen.notify('error','Não é possível selecionar o abono pecuniário se as férias forem parceladas');
    item = false;
  } else {
    totalDias = 0;
    periodo1Ok = this.blockly.js.blockly.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"));
    periodo2Ok = this.blockly.js.blockly.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"));
    periodo3Ok = this.blockly.js.blockly.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"));
    if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == 'no') {
      totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias"));
      if (!periodo1Ok) {
        this.cronapi.screen.notify('error','O \"1º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      }
    } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '2per') {
      totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias"));
      if (!periodo1Ok) {
        this.cronapi.screen.notify('error','O \"1º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      } else if (!periodo2Ok) {
        this.cronapi.screen.notify('error','O \"2º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      } else if (this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) < 10) {
        this.cronapi.screen.notify('error','O \"1º Período\" não contém o minímo de 10 dias de férias');
        item = false;
      } else if (this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias")) < 10) {
        this.cronapi.screen.notify('error','O \"2º Período\" não contém o minímo de 10 dias de férias');
        item = false;
      }
    } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '3per') {
      totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr3QtdDias"));
      if (!periodo1Ok) {
        this.cronapi.screen.notify('error','O \"1º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      } else if (!periodo2Ok) {
        this.cronapi.screen.notify('error','O \"2º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      } else if (!periodo3Ok) {
        this.cronapi.screen.notify('error','O \"3º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      } else if (this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) < 10) {
        this.cronapi.screen.notify('error','O \"1º Período\" não contém o minímo de 10 dias de férias');
        item = false;
      } else if (this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias")) < 10) {
        this.cronapi.screen.notify('error','O \"2º Período\" não contém o minímo de 10 dias de férias');
        item = false;
      } else if (this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr3QtdDias")) < 10) {
        this.cronapi.screen.notify('error','O \"3º Período\" não contém o minímo de 10 dias de férias');
        item = false;
      }
    }
    if (item) {
      if (totalDias > 30) {
        this.cronapi.screen.notify('error','O total de dias selecionados no períodos não podem ultrapassar 30 dias');
        item = false;
      } else if (this.cronapi.screen.getValueOfField("vars.primParcDecimTerc") == 'yes' && !this.blockly.js.blockly.TelaRequestVacationDetail.ValidarPeriodosPodeSolicitarAdiantamento13Salario()) {
        this.cronapi.screen.notify('error','Só possível receber a 1ª parcela do 13ª se o período das ferias estiver entre 01/01 e 15/02');
        item = false;
      }
    }
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.AdicionaDias = function(compDataInicial, compDias, compDataFinal) {
 var item, abonoPecuniario, DataFinal, DataInicial, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField(compDataInicial)) && !this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField(compDias))) {
    this.cronapi.screen.changeValueOfField(compDataFinal, this.cronapi.dateTime.incDay(this.cronapi.screen.getValueOfField(compDataInicial), this.cronapi.screen.getValueOfField(compDias)));
  }
}

/**
 * TelaRequestVacationDetail
 */
window.blockly.js.blockly.TelaRequestVacationDetail.SetarParametrosIniciais = function(dividirFerias, abonoPecuniario, primeiraParcelaDecimoTerceiro) {
 var item, compDataFinal, compDataInicial, compDias, DataFinal, DataInicial, dataInicialTexto, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, totalDias;
  if (dividirFerias == 'no') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.hideComponent("trPeriodo2");
    this.cronapi.screen.hideComponent("trPeriodo3");
    this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")));
    this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '30');
    this.cronapi.util.executeJavascriptNoReturn('$(\'[ng-model=\"vars.tr1QtdDias\"]\').data(\"kendoComboBox\").enable(false);');
    this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", this.cronapi.dateTime.incDay(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")), 30));
  } else if (dividirFerias == '2per') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.showComponent("trPeriodo2");
    this.cronapi.screen.hideComponent("trPeriodo3");
    this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", '');
    this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '');
    this.cronapi.util.executeJavascriptNoReturn('$(\'[ng-model=\"vars.tr1QtdDias\"]\').data(\"kendoComboBox\").enable(true);');
    this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", '');
  } else if (dividirFerias == '3per') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.showComponent("trPeriodo2");
    this.cronapi.screen.showComponent("trPeriodo3");
    this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", '');
    this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '');
    this.cronapi.util.executeJavascriptNoReturn('$(\'[ng-model=\"vars.tr1QtdDias\"]\').data(\"kendoComboBox\").enable(true);');
    this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", '');
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario = function(DataInicial, DataFinal) {
 var item, abonoPecuniario, compDataFinal, compDataInicial, compDias, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  if (this.cronapi.logic.isNullOrEmpty(DataInicial) || this.cronapi.logic.isNullOrEmpty(DataFinal)) {
    item = true;
  } else {
    item = DataInicial >= this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(DataInicial), 1, 1, 0, 0, 0) && DataFinal <= this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(DataInicial), 2, 15, 0, 0, 0);
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaRequestVacationDetail.ValidarPeriodosPodeSolicitarAdiantamento13Salario = function() {
 var item, abonoPecuniario, compDataFinal, compDataInicial, compDias, DataFinal, DataInicial, dataInicialTexto, dividirFerias, periodo1Ok, periodo2Ok, periodo3Ok, podeSolicitarAdian13Sal, primeiraParcelaDecimoTerceiro, totalDias;
  podeSolicitarAdian13Sal = this.blockly.js.blockly.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"));
  if (podeSolicitarAdian13Sal) {
    podeSolicitarAdian13Sal = this.blockly.js.blockly.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"));
    if (podeSolicitarAdian13Sal) {
      podeSolicitarAdian13Sal = this.blockly.js.blockly.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"));
    }
  }
  return podeSolicitarAdian13Sal;
}
