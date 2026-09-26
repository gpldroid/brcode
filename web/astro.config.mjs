import { defineConfig } from 'astro';
import sitemap from '@astrojs/sitemap';
export default defineConfig({site:'https://gpldroid.github.io/brcode',base:'/brcode',integrations:[sitemap()],output:'static'});