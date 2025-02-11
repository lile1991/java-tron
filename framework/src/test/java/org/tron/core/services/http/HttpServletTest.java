package org.tron.core.services.http;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@Slf4j
public class HttpServletTest {
  private AccountPermissionUpdateServlet accountPermissionUpdateServlet;
  private BroadcastHexServlet broadcastHexServlet;
  private BroadcastServlet broadcastServlet;
  private ClearABIServlet clearABIServlet;
  private CreateAccountServlet createAccountServlet;
  private CreateAssetIssueServlet createAssetIssueServlet;
  private CreateCommonTransactionServlet createCommonTransactionServlet;
  private CreateShieldedContractParametersServlet createShieldedContractParametersServlet;
  private CreateShieldedContractParametersWithoutAskServlet
      createShieldedContractParametersWithoutAskServlet;
  private CreateShieldedTransactionServlet createShieldedTransactionServlet;
  private CreateShieldedTransactionWithoutSpendAuthSigServlet
      createShieldedTransactionWithoutSpendAuthSigServlet;
  private CreateShieldNullifierServlet createShieldNullifierServlet;
  private CreateSpendAuthSigServlet createSpendAuthSigServlet;
  private CreateWitnessServlet createWitnessServlet;
  private DelegateResourceServlet delegateResourceServlet;
  private DeployContractServlet deployContractServlet;
  private EstimateEnergyServlet estimateEnergyServlet;
  private ExchangeCreateServlet exchangeCreateServlet;
  private ExchangeInjectServlet exchangeInjectServlet;
  private ExchangeTransactionServlet exchangeTransactionServlet;
  private ExchangeWithdrawServlet exchangeWithdrawServlet;
  private FreezeBalanceServlet freezeBalanceServlet;
  private FreezeBalanceV2Servlet freezeBalanceV2Servlet;
  private GetAccountBalanceServlet getAccountBalanceServlet;
  private GetAccountByIdServlet getAccountByIdServlet;
  private GetAccountNetServlet getAccountNetServlet;
  private GetAccountResourceServlet getAccountResourceServlet;
  private GetAccountServlet getAccountServlet;
  private GetAkFromAskServlet getAkFromAskServlet;
  private GetAssetIssueByAccountServlet getAssetIssueByAccountServlet;
  private GetAssetIssueByIdServlet getAssetIssueByIdServlet;
  private GetAssetIssueByNameServlet getAssetIssueByNameServlet;
  private GetAssetIssueListByNameServlet getAssetIssueListByNameServlet;
  private GetAssetIssueListServlet getAssetIssueListServlet;
  private GetAvailableUnfreezeCountServlet getAvailableUnfreezeCountServlet;
  private GetBandwidthPricesServlet getBandwidthPricesServlet;
  private GetBlockBalanceServlet getBlockBalanceServlet;
  private GetBlockByIdServlet getBlockByIdServlet;
  private GetBlockByLatestNumServlet getBlockByLatestNumServlet;
  private GetBlockByLimitNextServlet getBlockByLimitNextServlet;
  private GetBlockByNumServlet getBlockByNumServlet;
  private GetBlockServlet getBlockServlet;
  private GetBrokerageServlet getBrokerageServlet;
  private GetBurnTrxServlet getBurnTrxServlet;
  private GetCanDelegatedMaxSizeServlet getCanDelegatedMaxSizeServlet;
  private GetCanWithdrawUnfreezeAmountServlet getCanWithdrawUnfreezeAmountServlet;
  private GetChainParametersServlet getChainParametersServlet;
  private GetContractInfoServlet getContractInfoServlet;
  private GetContractServlet getContractServlet;
  private GetDelegatedResourceAccountIndexServlet getDelegatedResourceAccountIndexServlet;
  private GetDelegatedResourceAccountIndexV2Servlet getDelegatedResourceAccountIndexV2Servlet;
  private GetDelegatedResourceServlet getDelegatedResourceServlet;
  private GetDelegatedResourceV2Servlet getDelegatedResourceV2Servlet;
  private GetDiversifierServlet getDiversifierServlet;
  private GetEnergyPricesServlet getEnergyPricesServlet;
  private GetExchangeByIdServlet getExchangeByIdServlet;
  private GetExpandedSpendingKeyServlet getExpandedSpendingKeyServlet;
  private GetIncomingViewingKeyServlet getIncomingViewingKeyServlet;
  private GetMarketOrderByAccountServlet getMarketOrderByAccountServlet;
  private GetMarketOrderByIdServlet getMarketOrderByIdServlet;
  private GetMarketOrderListByPairServlet getMarketOrderListByPairServlet;
  private GetMarketPairListServlet getMarketPairListServlet;
  private GetMarketPriceByPairServlet getMarketPriceByPairServlet;
  private GetMemoFeePricesServlet getMemoFeePricesServlet;
  private GetMerkleTreeVoucherInfoServlet getMerkleTreeVoucherInfoServlet;
  private GetNewShieldedAddressServlet getNewShieldedAddressServlet;
  private GetNextMaintenanceTimeServlet getNextMaintenanceTimeServlet;
  private GetNkFromNskServlet getNkFromNskServlet;
  private GetNodeInfoServlet getNodeInfoServlet;
  private GetNowBlockServlet getNowBlockServlet;
  private GetPaginatedAssetIssueListServlet getPaginatedAssetIssueListServlet;
  private GetPaginatedExchangeListServlet getPaginatedExchangeListServlet;
  private GetPaginatedProposalListServlet getPaginatedProposalListServlet;
  private GetPendingSizeServlet getPendingSizeServlet;
  private GetProposalByIdServlet getProposalByIdServlet;
  private GetRcmServlet getRcmServlet;
  private GetRewardServlet getRewardServlet;
  private GetShieldTransactionHashServlet getShieldTransactionHashServlet;
  private GetSpendingKeyServlet getSpendingKeyServlet;
  private GetTransactionApprovedListServlet getTransactionApprovedListServlet;
  private GetTransactionByIdServlet getTransactionByIdServlet;
  private GetTransactionCountByBlockNumServlet getTransactionCountByBlockNumServlet;
  private GetTransactionFromPendingServlet getTransactionFromPendingServlet;
  private GetTransactionInfoByBlockNumServlet getTransactionInfoByBlockNumServlet;
  private GetTransactionInfoByIdServlet getTransactionInfoByIdServlet;
  private GetTransactionListFromPendingServlet getTransactionListFromPendingServlet;
  private GetTransactionReceiptByIdServlet getTransactionReceiptByIdServlet;
  private GetTransactionSignWeightServlet getTransactionSignWeightServlet;
  private GetTriggerInputForShieldedTRC20ContractServlet
      getTriggerInputForShieldedTRC20ContractServlet;
  private GetZenPaymentAddressServlet getZenPaymentAddressServlet;
  private IsShieldedTRC20ContractNoteSpentServlet isShieldedTRC20ContractNoteSpentServlet;
  private IsSpendServlet isSpendServlet;
  private ListExchangesServlet listExchangesServlet;
  private ListNodesServlet listNodesServlet;
  private ListProposalsServlet listProposalsServlet;
  private ListWitnessesServlet listWitnessesServlet;
  private MarketCancelOrderServlet marketCancelOrderServlet;
  private MarketSellAssetServlet marketSellAssetServlet;
  private MetricsServlet metricsServlet;
  private ParticipateAssetIssueServlet participateAssetIssueServlet;
  private ProposalApproveServlet proposalApproveServlet;
  private ProposalCreateServlet proposalCreateServlet;
  private ProposalDeleteServlet proposalDeleteServlet;
  private ScanAndMarkNoteByIvkServlet scanAndMarkNoteByIvkServlet;
  private ScanNoteByIvkServlet scanNoteByIvkServlet;
  private ScanNoteByOvkServlet scanNoteByOvkServlet;
  private ScanShieldedTRC20NotesByIvkServlet scanShieldedTRC20NotesByIvkServlet;
  private ScanShieldedTRC20NotesByOvkServlet scanShieldedTRC20NotesByOvkServlet;
  private SetAccountIdServlet setAccountIdServlet;
  private TotalTransactionServlet totalTransactionServlet;
  private TransferAssetServlet transferAssetServlet;
  private TransferServlet transferServlet;
  private TriggerConstantContractServlet triggerConstantContractServlet;
  private TriggerSmartContractServlet triggerSmartContractServlet;
  private UnDelegateResourceServlet unDelegateResourceServlet;
  private UnFreezeAssetServlet unFreezeAssetServlet;
  private UnFreezeBalanceServlet unFreezeBalanceServlet;
  private UnFreezeBalanceV2Servlet unFreezeBalanceV2Servlet;
  private UpdateAccountServlet updateAccountServlet;
  private UpdateAssetServlet updateAssetServlet;
  private UpdateBrokerageServlet updateBrokerageServlet;
  private UpdateEnergyLimitServlet updateEnergyLimitServlet;
  private UpdateSettingServlet updateSettingServlet;
  private UpdateWitnessServlet updateWitnessServlet;
  private ValidateAddressServlet validateAddressServlet;
  private VoteWitnessAccountServlet voteWitnessAccountServlet;
  private WithdrawBalanceServlet withdrawBalanceServlet;
  private WithdrawExpireUnfreezeServlet withdrawExpireUnfreezeServlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @Before
  public void setUp() {
    accountPermissionUpdateServlet = new AccountPermissionUpdateServlet();
    broadcastHexServlet = new BroadcastHexServlet();
    broadcastServlet = new BroadcastServlet();
    clearABIServlet = new ClearABIServlet();
    createAccountServlet = new CreateAccountServlet();
    createAssetIssueServlet = new CreateAssetIssueServlet();
    createCommonTransactionServlet = new CreateCommonTransactionServlet();
    createShieldedContractParametersServlet = new CreateShieldedContractParametersServlet();
    createShieldedContractParametersWithoutAskServlet =
        new CreateShieldedContractParametersWithoutAskServlet();
    createShieldedTransactionServlet = new CreateShieldedTransactionServlet();
    createShieldedTransactionWithoutSpendAuthSigServlet =
        new CreateShieldedTransactionWithoutSpendAuthSigServlet();
    createShieldNullifierServlet = new CreateShieldNullifierServlet();
    createSpendAuthSigServlet = new CreateSpendAuthSigServlet();
    createWitnessServlet = new CreateWitnessServlet();
    delegateResourceServlet = new DelegateResourceServlet();
    deployContractServlet = new DeployContractServlet();
    estimateEnergyServlet = new EstimateEnergyServlet();
    exchangeCreateServlet = new ExchangeCreateServlet();
    exchangeInjectServlet = new ExchangeInjectServlet();
    exchangeTransactionServlet = new ExchangeTransactionServlet();
    exchangeWithdrawServlet = new ExchangeWithdrawServlet();
    freezeBalanceServlet = new FreezeBalanceServlet();
    freezeBalanceV2Servlet = new FreezeBalanceV2Servlet();
    getAccountBalanceServlet = new GetAccountBalanceServlet();
    getAccountByIdServlet = new GetAccountByIdServlet();
    getAccountNetServlet = new GetAccountNetServlet();
    getAccountResourceServlet = new GetAccountResourceServlet();
    getAccountServlet = new GetAccountServlet();
    getAkFromAskServlet = new GetAkFromAskServlet();
    getAssetIssueByAccountServlet = new GetAssetIssueByAccountServlet();
    getAssetIssueByIdServlet = new GetAssetIssueByIdServlet();
    getAssetIssueByNameServlet = new GetAssetIssueByNameServlet();
    getAssetIssueListByNameServlet = new GetAssetIssueListByNameServlet();
    getAssetIssueListServlet = new GetAssetIssueListServlet();
    getAvailableUnfreezeCountServlet = new GetAvailableUnfreezeCountServlet();
    getBandwidthPricesServlet = new GetBandwidthPricesServlet();
    getBlockBalanceServlet = new GetBlockBalanceServlet();
    getBlockByIdServlet = new GetBlockByIdServlet();
    getBlockByLatestNumServlet = new GetBlockByLatestNumServlet();
    getBlockByLimitNextServlet = new GetBlockByLimitNextServlet();
    getBlockByNumServlet = new GetBlockByNumServlet();
    getBlockServlet = new GetBlockServlet();
    getBrokerageServlet = new GetBrokerageServlet();
    getBurnTrxServlet = new GetBurnTrxServlet();
    getCanDelegatedMaxSizeServlet = new GetCanDelegatedMaxSizeServlet();
    getCanWithdrawUnfreezeAmountServlet = new GetCanWithdrawUnfreezeAmountServlet();
    getChainParametersServlet = new GetChainParametersServlet();
    getContractInfoServlet = new GetContractInfoServlet();
    getContractServlet = new GetContractServlet();
    getDelegatedResourceAccountIndexServlet = new GetDelegatedResourceAccountIndexServlet();
    getDelegatedResourceAccountIndexV2Servlet = new GetDelegatedResourceAccountIndexV2Servlet();
    getDelegatedResourceServlet = new GetDelegatedResourceServlet();
    getDelegatedResourceV2Servlet = new GetDelegatedResourceV2Servlet();
    getDiversifierServlet = new GetDiversifierServlet();
    getEnergyPricesServlet = new GetEnergyPricesServlet();
    getExchangeByIdServlet = new GetExchangeByIdServlet();
    getExpandedSpendingKeyServlet = new GetExpandedSpendingKeyServlet();
    getIncomingViewingKeyServlet = new GetIncomingViewingKeyServlet();
    getMarketOrderByAccountServlet = new GetMarketOrderByAccountServlet();
    getMarketOrderByIdServlet = new GetMarketOrderByIdServlet();
    getMarketOrderListByPairServlet = new GetMarketOrderListByPairServlet();
    getMarketPairListServlet = new GetMarketPairListServlet();
    getMarketPriceByPairServlet = new GetMarketPriceByPairServlet();
    getMemoFeePricesServlet = new GetMemoFeePricesServlet();
    getMerkleTreeVoucherInfoServlet = new GetMerkleTreeVoucherInfoServlet();
    getNewShieldedAddressServlet = new GetNewShieldedAddressServlet();
    getNextMaintenanceTimeServlet = new GetNextMaintenanceTimeServlet();
    getNkFromNskServlet = new GetNkFromNskServlet();
    getNodeInfoServlet = new GetNodeInfoServlet();
    getNowBlockServlet = new GetNowBlockServlet();
    getPaginatedAssetIssueListServlet = new GetPaginatedAssetIssueListServlet();
    getPaginatedExchangeListServlet = new GetPaginatedExchangeListServlet();
    getPaginatedProposalListServlet = new GetPaginatedProposalListServlet();
    getPendingSizeServlet = new GetPendingSizeServlet();
    getProposalByIdServlet = new GetProposalByIdServlet();
    getRcmServlet = new GetRcmServlet();
    getRewardServlet = new GetRewardServlet();
    getShieldTransactionHashServlet = new GetShieldTransactionHashServlet();
    getSpendingKeyServlet = new GetSpendingKeyServlet();
    getTransactionApprovedListServlet = new GetTransactionApprovedListServlet();
    getTransactionByIdServlet = new GetTransactionByIdServlet();
    getTransactionCountByBlockNumServlet = new GetTransactionCountByBlockNumServlet();
    getTransactionFromPendingServlet = new GetTransactionFromPendingServlet();
    getTransactionInfoByBlockNumServlet = new GetTransactionInfoByBlockNumServlet();
    getTransactionInfoByIdServlet = new GetTransactionInfoByIdServlet();
    getTransactionListFromPendingServlet = new GetTransactionListFromPendingServlet();
    getTransactionReceiptByIdServlet = new GetTransactionReceiptByIdServlet();
    getTransactionSignWeightServlet = new GetTransactionSignWeightServlet();
    getTriggerInputForShieldedTRC20ContractServlet =
        new GetTriggerInputForShieldedTRC20ContractServlet();
    getZenPaymentAddressServlet = new GetZenPaymentAddressServlet();
    isShieldedTRC20ContractNoteSpentServlet = new IsShieldedTRC20ContractNoteSpentServlet();
    isSpendServlet = new IsSpendServlet();
    listExchangesServlet = new ListExchangesServlet();
    listNodesServlet = new ListNodesServlet();
    listProposalsServlet = new ListProposalsServlet();
    listWitnessesServlet = new ListWitnessesServlet();
    marketCancelOrderServlet = new MarketCancelOrderServlet();
    marketSellAssetServlet = new MarketSellAssetServlet();
    metricsServlet = new MetricsServlet();
    participateAssetIssueServlet = new ParticipateAssetIssueServlet();
    proposalApproveServlet = new ProposalApproveServlet();
    proposalCreateServlet = new ProposalCreateServlet();
    proposalDeleteServlet = new ProposalDeleteServlet();
    scanAndMarkNoteByIvkServlet = new ScanAndMarkNoteByIvkServlet();
    scanNoteByIvkServlet = new ScanNoteByIvkServlet();
    scanNoteByOvkServlet = new ScanNoteByOvkServlet();
    scanShieldedTRC20NotesByIvkServlet = new ScanShieldedTRC20NotesByIvkServlet();
    scanShieldedTRC20NotesByOvkServlet = new ScanShieldedTRC20NotesByOvkServlet();
    setAccountIdServlet = new SetAccountIdServlet();
    totalTransactionServlet = new TotalTransactionServlet();
    transferAssetServlet = new TransferAssetServlet();
    transferServlet = new TransferServlet();
    triggerConstantContractServlet = new TriggerConstantContractServlet();
    triggerSmartContractServlet = new TriggerSmartContractServlet();
    unDelegateResourceServlet = new UnDelegateResourceServlet();
    unFreezeAssetServlet = new UnFreezeAssetServlet();
    unFreezeBalanceServlet = new UnFreezeBalanceServlet();
    unFreezeBalanceV2Servlet = new UnFreezeBalanceV2Servlet();
    updateAccountServlet = new UpdateAccountServlet();
    updateAssetServlet = new UpdateAssetServlet();
    updateBrokerageServlet = new UpdateBrokerageServlet();
    updateEnergyLimitServlet = new UpdateEnergyLimitServlet();
    updateSettingServlet = new UpdateSettingServlet();
    updateWitnessServlet = new UpdateWitnessServlet();
    validateAddressServlet = new ValidateAddressServlet();
    voteWitnessAccountServlet = new VoteWitnessAccountServlet();
    withdrawBalanceServlet = new WithdrawBalanceServlet();
    withdrawExpireUnfreezeServlet = new WithdrawExpireUnfreezeServlet();
    request = new MockHttpServletRequest();
    request.setCharacterEncoding("UTF-8");
    response = new MockHttpServletResponse();
  }

  @Test
  public void doGetTest() {
    accountPermissionUpdateServlet.doGet(request, response);
    clearABIServlet.doGet(request, response);
    createAssetIssueServlet.doGet(request, response);
    createShieldedContractParametersServlet.doGet(request, response);
    createShieldedContractParametersWithoutAskServlet.doGet(request, response);
    createShieldedTransactionServlet.doGet(request, response);
    createShieldedTransactionWithoutSpendAuthSigServlet.doGet(request, response);
    createShieldNullifierServlet.doGet(request, response);
    createSpendAuthSigServlet.doGet(request, response);
    createWitnessServlet.doGet(request, response);
    deployContractServlet.doGet(request, response);
    estimateEnergyServlet.doGet(request, response);
    getAccountByIdServlet.doGet(request, response);
    getAccountNetServlet.doGet(request, response);
    getAccountResourceServlet.doGet(request, response);
    getAccountServlet.doGet(request, response);
    getAkFromAskServlet.doGet(request, response);
    getAssetIssueByAccountServlet.doGet(request, response);
    getAssetIssueByIdServlet.doGet(request, response);
    getAssetIssueByNameServlet.doGet(request, response);
    getAssetIssueListByNameServlet.doGet(request, response);
    getAssetIssueListServlet.doGet(request, response);
    getAvailableUnfreezeCountServlet.doGet(request, response);
    getBandwidthPricesServlet.doGet(request, response);
    getBlockByIdServlet.doGet(request, response);
    getBlockByLatestNumServlet.doGet(request, response);
    getBlockByLimitNextServlet.doGet(request, response);
    getBlockByNumServlet.doGet(request, response);
    getBlockServlet.doGet(request, response);
    getBrokerageServlet.doGet(request, response);
    getBurnTrxServlet.doGet(request, response);
    getCanDelegatedMaxSizeServlet.doGet(request, response);
    getCanWithdrawUnfreezeAmountServlet.doGet(request, response);
    getChainParametersServlet.doGet(request, response);
    getContractInfoServlet.doGet(request, response);
    getContractServlet.doGet(request, response);
    getDelegatedResourceAccountIndexServlet.doGet(request, response);
    getDelegatedResourceAccountIndexV2Servlet.doGet(request, response);
    getDelegatedResourceServlet.doGet(request, response);
    getDelegatedResourceV2Servlet.doGet(request, response);
    getDiversifierServlet.doGet(request, response);
    getEnergyPricesServlet.doGet(request, response);
    getExchangeByIdServlet.doGet(request, response);
    getExpandedSpendingKeyServlet.doGet(request, response);
    getIncomingViewingKeyServlet.doGet(request, response);
    getMarketOrderByAccountServlet.doGet(request, response);
    getMarketOrderByIdServlet.doGet(request, response);
    getMarketOrderListByPairServlet.doGet(request, response);
    getMarketPairListServlet.doGet(request, response);
    getMarketPriceByPairServlet.doGet(request, response);
    getMemoFeePricesServlet.doGet(request, response);
    getMerkleTreeVoucherInfoServlet.doGet(request, response);
    getNewShieldedAddressServlet.doGet(request, response);
    getNextMaintenanceTimeServlet.doGet(request, response);
    getNkFromNskServlet.doGet(request, response);
    getNodeInfoServlet.doGet(request, response);
    getNowBlockServlet.doGet(request, response);
    getPaginatedAssetIssueListServlet.doGet(request, response);
    getPaginatedExchangeListServlet.doGet(request, response);
    getPaginatedProposalListServlet.doGet(request, response);
    getPendingSizeServlet.doGet(request, response);
    getProposalByIdServlet.doGet(request, response);
    getRcmServlet.doGet(request, response);
    getRewardServlet.doGet(request, response);
    getShieldTransactionHashServlet.doGet(request, response);
    getSpendingKeyServlet.doGet(request, response);
    getTransactionApprovedListServlet.doGet(request, response);
    getTransactionByIdServlet.doGet(request, response);
    getTransactionCountByBlockNumServlet.doGet(request, response);
    getTransactionFromPendingServlet.doGet(request, response);
    getTransactionInfoByBlockNumServlet.doGet(request, response);
    getTransactionInfoByIdServlet.doGet(request, response);
    getTransactionListFromPendingServlet.doGet(request, response);
    getTransactionReceiptByIdServlet.doGet(request, response);
    getTransactionSignWeightServlet.doGet(request, response);
    getTriggerInputForShieldedTRC20ContractServlet.doGet(request, response);
    getZenPaymentAddressServlet.doGet(request, response);
    isShieldedTRC20ContractNoteSpentServlet.doGet(request, response);
    isSpendServlet.doGet(request, response);
    listExchangesServlet.doGet(request, response);
    listNodesServlet.doGet(request, response);
    listProposalsServlet.doGet(request, response);
    listWitnessesServlet.doGet(request, response);
    marketCancelOrderServlet.doGet(request, response);
    marketSellAssetServlet.doGet(request, response);
    metricsServlet.doGet(request, response);
    participateAssetIssueServlet.doGet(request, response);
    proposalApproveServlet.doGet(request, response);
    proposalCreateServlet.doGet(request, response);
    proposalDeleteServlet.doGet(request, response);
    scanAndMarkNoteByIvkServlet.doGet(request, response);
    scanNoteByIvkServlet.doGet(request, response);
    scanNoteByOvkServlet.doGet(request, response);
    scanShieldedTRC20NotesByIvkServlet.doGet(request, response);
    scanShieldedTRC20NotesByOvkServlet.doGet(request, response);
    setAccountIdServlet.doGet(request, response);
    totalTransactionServlet.doGet(request, response);
    transferAssetServlet.doGet(request, response);
    transferServlet.doGet(request, response);
    triggerConstantContractServlet.doGet(request, response);
    triggerSmartContractServlet.doGet(request, response);
    unDelegateResourceServlet.doGet(request, response);
    unFreezeAssetServlet.doGet(request, response);
    unFreezeBalanceServlet.doGet(request, response);
    unFreezeBalanceV2Servlet.doGet(request, response);
    updateAccountServlet.doGet(request, response);
    updateAssetServlet.doGet(request, response);
    updateEnergyLimitServlet.doGet(request, response);
    updateSettingServlet.doGet(request, response);
    updateWitnessServlet.doGet(request, response);
    validateAddressServlet.doGet(request, response);
    voteWitnessAccountServlet.doGet(request, response);
    withdrawBalanceServlet.doGet(request, response);
    withdrawExpireUnfreezeServlet.doGet(request, response);
  }


  @Test
  public void doPostTest() {
    request.addParameter("owner_address", "TZ4UXDV5ZhNW7fb2AMSbgfAEZ7hWsnYS2g");
    accountPermissionUpdateServlet.doPost(request, response);
    broadcastHexServlet.doPost(request, response);
    broadcastServlet.doPost(request, response);
    clearABIServlet.doPost(request, response);
    createAccountServlet.doPost(request, response);
    createAssetIssueServlet.doPost(request, response);
    createCommonTransactionServlet.doPost(request, response);
    createShieldedContractParametersServlet.doPost(request, response);
    createShieldedContractParametersWithoutAskServlet.doPost(request, response);
    createShieldedTransactionServlet.doPost(request, response);
    createShieldedTransactionWithoutSpendAuthSigServlet.doPost(request, response);
    createShieldNullifierServlet.doPost(request, response);
    createSpendAuthSigServlet.doPost(request, response);
    createWitnessServlet.doPost(request, response);
    delegateResourceServlet.doPost(request, response);
    deployContractServlet.doPost(request, response);
    exchangeCreateServlet.doPost(request, response);
    exchangeInjectServlet.doPost(request, response);
    exchangeTransactionServlet.doPost(request, response);
    exchangeWithdrawServlet.doPost(request, response);
    freezeBalanceServlet.doPost(request, response);
    freezeBalanceV2Servlet.doPost(request, response);
    getAccountBalanceServlet.doPost(request, response);
    getAccountByIdServlet.doPost(request, response);
    getAccountNetServlet.doPost(request, response);
    getAccountResourceServlet.doPost(request, response);
    getAccountServlet.doPost(request, response);
    getAkFromAskServlet.doPost(request, response);
    getAssetIssueByAccountServlet.doPost(request, response);
    getAssetIssueByIdServlet.doPost(request, response);
    getAssetIssueByNameServlet.doPost(request, response);
    getAssetIssueListByNameServlet.doPost(request, response);
    getAssetIssueListServlet.doPost(request, response);
    getAvailableUnfreezeCountServlet.doPost(request, response);
    getBandwidthPricesServlet.doPost(request, response);
    getBlockBalanceServlet.doPost(request, response);
    getBlockByIdServlet.doPost(request, response);
    getBlockByLatestNumServlet.doPost(request, response);
    getBlockByLimitNextServlet.doPost(request, response);
    getBlockByNumServlet.doPost(request, response);
    getBlockServlet.doPost(request, response);
    getBrokerageServlet.doPost(request, response);
    getBurnTrxServlet.doPost(request, response);
    getCanDelegatedMaxSizeServlet.doPost(request, response);
    getCanWithdrawUnfreezeAmountServlet.doPost(request, response);
    getChainParametersServlet.doPost(request, response);
    getContractInfoServlet.doPost(request, response);
    getContractServlet.doPost(request, response);
    getDelegatedResourceAccountIndexServlet.doPost(request, response);
    getDelegatedResourceAccountIndexV2Servlet.doPost(request, response);
    getDelegatedResourceServlet.doPost(request, response);
    getDelegatedResourceV2Servlet.doPost(request, response);
    getDiversifierServlet.doPost(request, response);
    getEnergyPricesServlet.doPost(request, response);
    getExchangeByIdServlet.doPost(request, response);
    getExpandedSpendingKeyServlet.doPost(request, response);
    getIncomingViewingKeyServlet.doPost(request, response);
    getMarketOrderByAccountServlet.doPost(request, response);
    getMarketOrderByIdServlet.doPost(request, response);
    getMarketOrderListByPairServlet.doPost(request, response);
    getMarketPairListServlet.doPost(request, response);
    getMarketPriceByPairServlet.doPost(request, response);
    getMemoFeePricesServlet.doPost(request, response);
    getMerkleTreeVoucherInfoServlet.doPost(request, response);
    getNewShieldedAddressServlet.doPost(request, response);
    getNextMaintenanceTimeServlet.doPost(request, response);
    getNkFromNskServlet.doPost(request, response);
    getNodeInfoServlet.doPost(request, response);
    getNowBlockServlet.doPost(request, response);
    getPaginatedAssetIssueListServlet.doPost(request, response);
    getPaginatedExchangeListServlet.doPost(request, response);
    getPaginatedProposalListServlet.doPost(request, response);
    getPendingSizeServlet.doPost(request, response);
    getProposalByIdServlet.doPost(request, response);
    getRcmServlet.doPost(request, response);
    getRewardServlet.doPost(request, response);
    getShieldTransactionHashServlet.doPost(request, response);
    getSpendingKeyServlet.doPost(request, response);
    getTransactionApprovedListServlet.doPost(request, response);
    getTransactionByIdServlet.doPost(request, response);
    getTransactionCountByBlockNumServlet.doPost(request, response);
    getTransactionFromPendingServlet.doPost(request, response);
    getTransactionInfoByBlockNumServlet.doPost(request, response);
    getTransactionInfoByIdServlet.doPost(request, response);
    getTransactionListFromPendingServlet.doPost(request, response);
    getTransactionReceiptByIdServlet.doPost(request, response);
    getTransactionSignWeightServlet.doPost(request, response);
    getTriggerInputForShieldedTRC20ContractServlet.doPost(request, response);
    getZenPaymentAddressServlet.doPost(request, response);
    isShieldedTRC20ContractNoteSpentServlet.doPost(request, response);
    isSpendServlet.doPost(request, response);
    listExchangesServlet.doPost(request, response);
    listNodesServlet.doPost(request, response);
    listProposalsServlet.doPost(request, response);
    listWitnessesServlet.doPost(request, response);
    marketCancelOrderServlet.doPost(request, response);
    marketSellAssetServlet.doPost(request, response);
    participateAssetIssueServlet.doPost(request, response);
    proposalApproveServlet.doPost(request, response);
    proposalCreateServlet.doPost(request, response);
    proposalDeleteServlet.doPost(request, response);
    scanAndMarkNoteByIvkServlet.doPost(request, response);
    scanNoteByIvkServlet.doPost(request, response);
    scanNoteByOvkServlet.doPost(request, response);
    scanShieldedTRC20NotesByIvkServlet.doPost(request, response);
    scanShieldedTRC20NotesByOvkServlet.doPost(request, response);
    setAccountIdServlet.doPost(request, response);
    totalTransactionServlet.doPost(request, response);
    transferAssetServlet.doPost(request, response);
    transferServlet.doPost(request, response);
    unDelegateResourceServlet.doPost(request, response);
    unFreezeAssetServlet.doPost(request, response);
    unFreezeBalanceServlet.doPost(request, response);
    unFreezeBalanceV2Servlet.doPost(request, response);
    updateAccountServlet.doPost(request, response);
    updateAssetServlet.doPost(request, response);
    updateBrokerageServlet.doPost(request, response);
    updateEnergyLimitServlet.doPost(request, response);
    updateSettingServlet.doPost(request, response);
    updateWitnessServlet.doPost(request, response);
    validateAddressServlet.doPost(request, response);
    voteWitnessAccountServlet.doPost(request, response);
    withdrawBalanceServlet.doPost(request, response);
    withdrawExpireUnfreezeServlet.doPost(request, response);
  }

}
