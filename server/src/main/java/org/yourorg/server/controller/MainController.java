package org.yourorg.server.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        // Create base redirect URI
        StringBuilder returnVal = new StringBuilder("redirect:/err/");

        // Get status code and origin URI
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object originUri = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        // Check that status code and origin URI aren't null
        if (statusCode == null) throw new NullPointerException("Status code is null");
        if (originUri == null) throw new NullPointerException("Origin URI is null");

        // Append appropriate status code message
        returnVal.append(switch(Integer.parseInt(statusCode.toString())) {
            case 400 -> { yield "bad-request"; }
            case 401 -> { yield "unauthorised"; }
            case 402 -> { yield "payment-required"; }
            case 403 -> { yield "forbidden"; }
            case 404 -> { yield "not-found"; }
            case 405 -> { yield "method-not-allowed"; }
            case 406 -> { yield "not-acceptable"; }
            case 407 -> { yield "proxy-authentication-required"; }
            case 408 -> { yield "request-timeout"; }
            case 409 -> { yield "conflict"; }
            case 410 -> { yield "gone"; }
            case 411 -> { yield "length-required"; }
            case 412 -> { yield "precondition-failed"; }
            case 413 -> { yield "payload-too-large"; }
            case 414 -> { yield "uri-too-long"; }
            case 415 -> { yield "unsupported-media-type"; }
            case 416 -> { yield "requested-range-not-satisfiable"; }
            case 417 -> { yield "expectation-failed"; }
            case 418 -> { yield "im-a-teapot"; }
            case 422 -> { yield "unprocessable-entity"; }
            case 423 -> { yield "locked"; }
            case 424 -> { yield "failed-dependency"; }
            case 425 -> { yield "too-early"; }
            case 426 -> { yield "upgrade-required"; }
            case 428 -> { yield "precondition-required"; }
            case 429 -> { yield "too-many-requests"; }
            case 431 -> { yield "request-header-fields-too-large"; }
            case 451 -> { yield "unavailable-for-legal-reasons"; }
            case 500 -> { yield "internal-server-error"; }
            case 501 -> { yield "not-implemented"; }
            case 502 -> { yield "bad-gateway"; }
            case 503 -> { yield "service-unavailable"; }
            case 504 -> { yield "gateway-timeout"; }
            case 505 -> { yield "http-version-not-supported"; }
            case 506 -> { yield "variant-also-negotiates"; }
            case 507 -> { yield "insufficient-storage"; }
            case 508 -> { yield "loop-detected"; }
            case 509 -> { yield "bandwidth-limit-exceeded"; }
            case 510 -> { yield "not-extended"; }
            case 511 -> { yield "network-authentication-required"; }
            default -> { yield "unknown"; }
        });

        // Append error-causing origin URI
        returnVal.append(String.format("?origin=%s", originUri));

        return returnVal.toString();
    }

}