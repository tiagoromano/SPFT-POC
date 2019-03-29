window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.requestVacation = window.blockly.js.blockly.requestVacation || {};
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail = window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante = function(DataInicial, DataFinal, dataAChecar) {
 var item, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  if (this.cronapi.logic.isNullOrEmpty(DataInicial) || this.cronapi.logic.isNullOrEmpty(DataFinal) || this.cronapi.logic.isNullOrEmpty(dataAChecar)) {
    item = false;
  } else {
    item = dataAChecar >= DataInicial && dataAChecar <= DataFinal;
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.CriarSolicitacao = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.ValidarSolicitacao()) {
    SolicitacaoFerias = this.cronapi.object.newObject({name: 'periodoConcessao', value: this.cronapi.object.newObject({name: 'forcaTrabalho', value: this.cronapi.object.newObject({name: 'codigoLogin', value: this.cronapi.screen.getValueOfField("params.login")})}, {name: 'dataConcessaoInicial', value: this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial"))}, {name: 'dataConcessaoFinal', value: this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataFinal"))}, {name: 'dataAquisicaoInicial', value: this.cronapi.dateTime.incYear(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")), -1)}, {name: 'dataAquisicaoFinal', value: this.cronapi.dateTime.incYear(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataFinal")), -1)}, {name: 'totalDiasContigente', value: this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.SomarTotalDiasFerias()})}, {name: 'justificativa', value: this.cronapi.screen.getValueOfField("vars.justificativa")}, {name: 'status', value: undefined}, {name: 'utilizaAbono', value: this.cronapi.screen.getValueOfField("vars.abonoPecuniario") == 'yes' ? 1 : 0}, {name: 'adiantaDecimo', value: this.cronapi.screen.getValueOfField("vars.primParcDecimTerc") == 'yes' ? 1 : 0}, {name: 'dividir', value: this.cronapi.screen.getValueOfField("vars.dividirFerias") == 'no' ? 0 : 1}, {name: 'dataPeriodo1Inicio', value: this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"))}, {name: 'dataPeriodo1Fim', value: this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr1DataFinal"))}, {name: 'dataPeriodo2Inicio', value: this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.tr2DataInicio")) ? null : this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"))}, {name: 'dataPeriodo2Fim', value: this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.tr2DataFinal")) ? null : this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr2DataFinal"))}, {name: 'dataAtualizacaoDate', value: this.cronapi.dateTime.getNow()}, {name: 'dataPeriodo3Inicio', value: this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.tr3DataInicio")) ? null : this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"))}, {name: 'dataPeriodo3Fim', value: this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.tr3DataFinal")) ? null : this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("vars.tr3DataFinal"))}, {name: 'dataAtualizacao', value: this.cronapi.dateTime.getNow()});
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Ferias:SalvarSolicitacaoFerias', function(sender_item) {
        item = sender_item;
      if (item.indexOf('sucesso') + 1 > 0) {
        this.cronapi.screen.notify('success',item);
        this.cronapi.screen.changeView("#/app/logged/RequestVacation",[ { login : this.cronapi.screen.getValueOfField("params.login") } ]);
      } else {
        this.cronapi.screen.notify('error',item);
      }
    }.bind(this), SolicitacaoFerias);
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo = function(DataInicial, DataFinal) {
 var item, dataAChecar, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
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
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.AoEntrar = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  this.cronapi.screen.changeValueOfField("vars.abonoPecuniario", false);
  this.cronapi.screen.changeValueOfField("vars.primParcDecimTerc", false);
  this.cronapi.screen.changeViewValue("params.arquisicaoDataFinal", '');
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.ValidarSolicitacao = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
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
    totalDias = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.SomarTotalDiasFerias();
    periodo1Ok = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"));
    periodo2Ok = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"));
    periodo3Ok = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.EstaDentroPeriodoAquisitivo(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"));
    if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == 'no') {
      if (!periodo1Ok) {
        this.cronapi.screen.notify('error','O \"1º Período\" não está dentro do Periodo Aquisitivo');
        item = false;
      }
    } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '2per') {
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
      } else if (totalDias < 30) {
        this.cronapi.screen.notify('error','O total de dias selecionados no períodos não pode ser menor que 30 dias');
        item = false;
      } else if (this.cronapi.screen.getValueOfField("vars.primParcDecimTerc") == 'yes' && !this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.ValidarPeriodosPodeSolicitarAdiantamento13Salario()) {
        this.cronapi.screen.notify('error','Só possível receber a 1ª parcela do 13ª se o período das ferias estiver entre 01/01 e 15/02');
        item = false;
      } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarPeriodosConflitantes()) {
        item = false;
      }
    }
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.AdicionaDias = function(compDataInicial, compDias, compDataFinal) {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  if (!this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField(compDataInicial)) && !this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField(compDias))) {
    this.cronapi.screen.changeValueOfField(compDataFinal, this.cronapi.dateTime.incDay(this.cronapi.screen.getValueOfField(compDataInicial), this.cronapi.screen.getValueOfField(compDias)));
    this.cronapi.screen.changeValueOfField(String(compDataFinal) + String('View'), this.cronapi.dateTime.formatDateTime(this.cronapi.dateTime.incDay(this.cronapi.screen.getValueOfField(compDataInicial), this.cronapi.screen.getValueOfField(compDias)), 'DD/MM/YYYY'));
  }
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario = function(DataInicial, DataFinal) {
 var item, dataAChecar, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  if (this.cronapi.logic.isNullOrEmpty(DataInicial) || this.cronapi.logic.isNullOrEmpty(DataFinal)) {
    item = true;
  } else {
    item = DataInicial >= this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(DataInicial), 1, 1, 0, 0, 0) && DataFinal <= this.cronapi.dateTime.newDate(this.cronapi.dateTime.getYear(DataInicial), 2, 15, 0, 0, 0);
  }
  return item;
}

/**
 * TelaRequestVacationDetail
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.SetarParametrosIniciais = function(dividirFerias, abonoPecuniario, primeiraParcelaDecimoTerceiro) {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, podeSolicitarAdian13Sal, dataAtualValidar;
  this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", '');
  this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '');
  this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", '');
  this.cronapi.screen.changeValueOfField("vars.tr2DataInicio", '');
  this.cronapi.screen.changeValueOfField("vars.tr2QtdDias", '');
  this.cronapi.screen.changeValueOfField("vars.tr2DataFinal", '');
  this.cronapi.screen.changeValueOfField("vars.tr3DataInicio", '');
  this.cronapi.screen.changeValueOfField("vars.tr3QtdDias", '');
  this.cronapi.screen.changeValueOfField("vars.tr3DataFinal", '');
  if (dividirFerias == 'no') {
    this.cronapi.screen.showComponent("trPeriodo1");
    this.cronapi.screen.hideComponent("trPeriodo2");
    this.cronapi.screen.hideComponent("trPeriodo3");
    this.cronapi.screen.changeValueOfField("vars.tr1DataInicio", this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")));
    this.cronapi.screen.changeValueOfField("vars.tr1QtdDias", '30');
    this.cronapi.screen.changeValueOfField("vars.tr1DataFinal", this.cronapi.dateTime.formatDateTime(this.cronapi.dateTime.incDay(this.cronapi.conversion.stringToDate(this.cronapi.screen.getValueOfField("params.arquisicaoDataInicial")), 30), 'DD/MM/YYYY'));
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

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.SomarTotalDiasFerias = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  totalDias = 0;
  if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == 'no') {
    totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias"));
  } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '2per') {
    totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias"));
  } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '3per') {
    totalDias = this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr1QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr2QtdDias")) + this.cronapi.conversion.toLong(this.cronapi.screen.getValueOfField("vars.tr3QtdDias"));
  }
  return totalDias;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.Cancelar = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  this.cronapi.screen.changeView("#/home/logged/requestVacation",[ { login : this.cronapi.screen.getValueOfField("params.login") } ]);
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.ValidarPeriodosPodeSolicitarAdiantamento13Salario = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  podeSolicitarAdian13Sal = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"));
  if (podeSolicitarAdian13Sal) {
    podeSolicitarAdian13Sal = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"));
    if (podeSolicitarAdian13Sal) {
      podeSolicitarAdian13Sal = this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.PodeSolicitarAdiantamento13Salario(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"));
    }
  }
  return podeSolicitarAdian13Sal;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarPeriodosConflitantes = function() {
 var item, DataFinal, dataAChecar, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  item = false;
  if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"), this.cronapi.screen.getValueOfField("vars.tr1DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"))) {
    this.cronapi.screen.notify('error','O \"1º Período\" está conflitando com \"2º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"), this.cronapi.screen.getValueOfField("vars.tr1DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"))) {
    this.cronapi.screen.notify('error','O \"1º Período\" está conflitando com \"3º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"), this.cronapi.screen.getValueOfField("vars.tr2DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"))) {
    this.cronapi.screen.notify('error','O \"2º Período\" está conflitando com \"1º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"), this.cronapi.screen.getValueOfField("vars.tr2DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"))) {
    this.cronapi.screen.notify('error','O \"2º Período\" está conflitando com \"3º Periodo\"');
    item = true;
  } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '2per' && this.cronapi.screen.getValueOfField("vars.tr2DataInicio") < this.cronapi.screen.getValueOfField("vars.tr1DataInicio")) {
    this.cronapi.screen.notify('error','O \"2º Período\" não pode ser anterior ao \"1º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"), this.cronapi.screen.getValueOfField("vars.tr3DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"), this.cronapi.screen.getValueOfField("vars.tr1DataFinal"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"))) {
    this.cronapi.screen.notify('error','O \"3º Período\" está conflitando com \"1º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"), this.cronapi.screen.getValueOfField("vars.tr3DataInicio")) || this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.VerificarDataConflitante(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"), this.cronapi.screen.getValueOfField("vars.tr2DataFinal"), this.cronapi.screen.getValueOfField("vars.tr3DataFinal"))) {
    this.cronapi.screen.notify('error','O \"3º Período\" está conflitando com \"2º Periodo\"');
    item = true;
  } else if (this.cronapi.screen.getValueOfField("vars.dividirFerias") == '3per' && this.cronapi.screen.getValueOfField("vars.tr3DataInicio") < this.cronapi.screen.getValueOfField("vars.tr2DataInicio")) {
    this.cronapi.screen.notify('error','O \"3º Período\" não pode ser anterior ao \"2º Periodo\"');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.MenorQueDataCorrente(this.cronapi.screen.getValueOfField("vars.tr1DataInicio"))) {
    this.cronapi.screen.notify('error','O \"1º Período\" não pode iniciar antes ou no mesmo dia da data atual ');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.MenorQueDataCorrente(this.cronapi.screen.getValueOfField("vars.tr2DataInicio"))) {
    this.cronapi.screen.notify('error','O \"2º Período\" não pode iniciar antes ou no mesmo dia da data atual ');
    item = true;
  } else if (this.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.MenorQueDataCorrente(this.cronapi.screen.getValueOfField("vars.tr3DataInicio"))) {
    this.cronapi.screen.notify('error','O \"3º Período\" não pode iniciar antes ou no mesmo dia da data atual ');
    item = true;
  }
  return item;
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.requestVacation.TelaRequestVacationDetail.MenorQueDataCorrente = function(dataAChecar) {
 var item, DataFinal, DataInicial, SolicitacaoFerias, totalDias, periodo3Ok, periodo2Ok, periodo1Ok, compDias, compDataInicial, compDataFinal, dividirFerias, podeSolicitarAdian13Sal, dataAtualValidar, abonoPecuniario, primeiraParcelaDecimoTerceiro;
  item = false;
  if (!this.cronapi.logic.isNullOrEmpty(dataAChecar)) {
    dataAtualValidar = this.cronapi.dateTime.getNow();
    item = dataAChecar < dataAtualValidar;
  }
  return item;
}
