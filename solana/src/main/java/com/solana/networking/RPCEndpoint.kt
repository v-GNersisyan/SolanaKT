package com.solana.networking

import java.net.URL

const val MAINNETBETA = "mainnet-beta"
const val DEVNET = "devnet"
const val TESTNET = "testnet"

sealed class Network(val name: String) {
    object mainnetBeta: Network(MAINNETBETA)
    object devnet: Network(DEVNET)
    object testnet: Network(TESTNET)
    var cluster: String = this.name
}


sealed class RPCEndpoint(open val url: URL, open val urlWebSocket: URL, open val network: Network) {
    object mainnetBetaSolana: RPCEndpoint(URL("https://wild-special-mountain.solana-mainnet.quiknode.pro/3e13818e9db86386837ff3b18cb004d9d5aa09e3/"), URL("https://wild-special-mountain.solana-mainnet.quiknode.pro/3e13818e9db86386837ff3b18cb004d9d5aa09e3/"), Network.mainnetBeta)
    object devnetSolana: RPCEndpoint(URL("https://api.devnet.solana.com"), URL("https://api.devnet.solana.com"), Network.devnet)
    object testnetSolana: RPCEndpoint(URL("https://testnet.solana.com"), URL("https://testnet.solana.com"),Network.testnet)
    data class custom(override val url: URL, override val urlWebSocket: URL, override val network: Network) : RPCEndpoint(url, urlWebSocket, network)
}