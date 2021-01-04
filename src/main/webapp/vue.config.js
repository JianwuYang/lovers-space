module.exports = {
  devServer: {
    open: true,
    port: "9000",
    host: "localhost",
    proxy: {
      '/rest': {
        target: 'http://localhost:8090/rest/',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/api': ''//请求的时候使用这个api就可以
        }

      }
    },
  },
  pluginOptions: {
    'style-resources-loader': {
      preProcessor: 'less',
      patterns: []
    }
  },
  css: {
    requireModuleExtension: true,
    sourceMap: true,
    loaderOptions: {
      less: {
        lessOptions: {
          javascriptEnabled: true
        },
      },
    },
  }
}
