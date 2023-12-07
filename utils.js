const prompt = require('prompt-sync')();

function getPromptAsNumber(choice){
    const prompt_value = prompt();
    return parseInt(prompt_value);
}

function getPromptAsFloat(choice){
    const prompt_value = prompt();
    return parseFloat(prompt_value);
}

module.exports = {
    getPromptAsNumber,
    getPromptAsFloat
};