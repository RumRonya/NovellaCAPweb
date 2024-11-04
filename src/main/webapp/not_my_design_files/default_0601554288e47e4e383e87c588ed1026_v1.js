
; /* Start:"a:4:{s:4:"full";s:88:"/local/templates/.default/components/bitrix/main.register/popup/script.js?16316182623355";s:6:"source";s:73:"/local/templates/.default/components/bitrix/main.register/popup/script.js";s:3:"min";s:0:"";s:3:"map";s:0:"";}"*/
// --------------------------------------- //
// Проверка полей флрмы //
// --------------------------------------- //
if(typeof checkFormFields != 'function') {
    function checkFormFields(element) {
        var inputOPD = BX.findChild(BX(element), {"tag" : "input","attribute" : { "name" : "PROP[OPD]"  }}, true);
        var inputPHONE = BX.findChild(BX(element), {"tag" : "input","attribute" : { "name" : "REGISTER[PERSONAL_PHONE]"  }}, true);

        var result = [];
        result.MESSAGE_ERROR = [];

        if (inputPHONE.value.indexOf('_') != -1 || inputPHONE.value.charAt(4) != '9') {
            result.MESSAGE_ERROR.push("Проверьте, пожалуйста, введенные мобильный номер ниже");
        }

        if( inputOPD.checked )
        {
            if(result.MESSAGE_ERROR.length > 0)
            {
                showRegisterErrors();
            } else {
                gtag('event', 'Registracia', {'event_category': 'Registracia', 'event_action': 'Zaregistrirovatsya'});
                yaCounter52259335.reachGoal('Registracia');

                element.submit();
            }
        }
        else
        {
            if( !inputOPD.checked )
            {
                result.MESSAGE_ERROR.push("Вы не дали согласие на обработку персональных данных. Вы не согласны с пользовательским соглашением");
            }

            if(result.MESSAGE_ERROR.length > 0)
            {
                showRegisterErrors();
            }
        }

        function showRegisterErrors() {
            var messageErr = BX.findChild(BX(document), {"class" : "message_err"}, true);
            if (messageErr)
            {
                BX.remove(messageErr);
            }

            ME = [];
            var countError = 1;

            for (i = 0; i < result.MESSAGE_ERROR.length; i++)
            {
                ME.push(
                    BX.create('DIV', {
                        html: countError+') '+result.MESSAGE_ERROR[i],
                    })
                );

                countError++;
            }

            var ContainerME =  BX.create('DIV', {
                props: {
                    className: 'message_err'
                },
                children: ME,
            });

            if(element)
            {
                element.prepend(ContainerME);

                setTimeout(
                    BX.delegate(function(){
                        BX.remove(ContainerME);
                    }, this),
                    4000
                );
            }
        }
    }
}


var timeOut = 100;
var onLoadFormRegister = function(){
	$('input[type="tel"]').each(function () {
		$(this).inputmask({
			mask:'+7 (999) 999 99 99',
			onBeforePaste: function (pastedValue, opts) {
				var phone = pastedValue.replace(/[\s|(|)]/g, "");

				if (phone.length > 10) {

					return phone.substr(phone.length - 10);
				}

				return phone;
			},
		});
	});
}

function setTimeOutPhone(){
	if($('#registracia').length){
		onLoadFormRegister();
	}else{
		setTimeout(function(){
			setTimeOutPhone();
		}, timeOut);
	}
}
setTimeOutPhone();
/* End */
;; /* /local/templates/.default/components/bitrix/main.register/popup/script.js?16316182623355*/
