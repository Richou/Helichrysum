(function ($) {

    var P = $.popup = function () {
        P.initialize.apply();
    }

    $.extend(P, {
        version: '1.0.0',
        defaults: {
            backgroundColor: "#fff",
            closeMethod: 'escape',
            css: { display: 'block', opacity: '0.5' },
            templates: {
                background: '<div class="background-popup" id="backgroundPopup"></div>',
                corps: '<div class="a-f f-h" id="coolPopup" style="display: none;">{corps}</div>'
            }
        },
        opts: {},
        content: null,
        _instance: null,
        initialize: function () {
            alert("Initialize");
        },
        open: function (content, opts) {
            P.opts = $.extend(true, {}, P.defaults, opts);
            if (P.content == null) {
                P.content = content;
            }
            P._do();
        },
        close: function () {
            $('#backgroundPopup').remove();
            $('#coolPopup').fadeOut(350, function () {
                $('#coolPopup').remove();
            });
            $(window).unbind('rezise');
        },
        _do: function () {
            $(P.opts.templates.background).css(P.opts.css).css({ backgroundColor: P.opts.backgroundColor }).appendTo('body');
			console.log(P.opts.closeMethod);
            switch (String(P.opts.closeMethod)) {
                case 'escape':
                    $(document).bind('keyup', function (event) {
                        console.log("keyup");
                        if (event.keyCode == 27) {
                            P.close();
                            $(document).unbind('keyup');
                        }
                    });
                    break;
                default:
                    alert("not found");
                    break;
            }
            var currentCorps = P.opts.templates.corps.replace("{corps}", P.content);
            $('body').append(currentCorps)
            var pop = $('#coolPopup');
            pop.fadeIn(350);
            P._centerBlock(pop);
            $(window).bind('resize', function () {
                P._centerBlock(pop);
            });
        },

        _centerBlock: function (elem) {
            var imageHeight = elem.outerHeight();
            var imageWidth = elem.outerWidth();
            var windowWidth = $(window).width();
            var windowHeight = $(window).height();

            elem.css({
                "left": Math.max(0, ((windowWidth - imageWidth) / 2) + $(window).scrollLeft()) + "px",
                "top": Math.max(0, ((windowHeight - imageHeight) / 2) + $(window).scrollTop()) + "px"
            });
        }

    });

    $.fn.popup = function (opts) {
        var currentDiv = $(this);
        P.open(currentDiv.html(), opts);
    };
})(jQuery);