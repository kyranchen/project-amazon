import { createI18n } from 'vue-i18n';

import en from './en.json';
import zh_TW from './zh_TW.json';

//import messages from language json pack
const messages = {
    en, 
    zh_TW,
};
//Default language to mandarin
const storedLang = localStorage.getItem('lang') !== null ? localStorage.getItem('lang') : 'zh_TW';

const i18n = createI18n({
    locale: storedLang, 
    messages, 
    legacy: false,
});

export default i18n;

// Change display language
export function setLanguage(lang) {
  i18n.global.locale.value = lang; 
}
