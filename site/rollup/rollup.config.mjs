import dynamicImportVars from '@rollup/plugin-dynamic-import-vars';

/**
 * @type {import('rollup').RollupOptions}
 */
export default {
    input: "../../build/js/packages/zenmo-site/kotlin/zenmo-site/main.export.mjs",
    output: {
        dir: "../build/rollup",
        format: "module",
        entryFileNames: "[name].mjs",
        chunkFileNames: "[name]-[hash].mjs",
        sourcemap: "hidden",
    },
    preserveEntrySignatures: "allow-extension",
    plugins: [
        dynamicImportVars({
            errorWhenNoFilesFound: true,
        })
    ]
}
