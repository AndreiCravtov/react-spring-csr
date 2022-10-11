import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  build: {
    outDir: "./../server/src/main/resources/static/",
    emptyOutDir: true,
    chunkSizeWarningLimit: 500,
    minify: `terser`,
    rollupOptions: {
      output: {
        entryFileNames: "[name].[hash].js",
        chunkFileNames: "[name].[hash].js",
        assetFileNames: "[name].[hash].[ext]"
      }
    }
  }
})
