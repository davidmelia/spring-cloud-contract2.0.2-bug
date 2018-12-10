package contracts.update

org.springframework.cloud.contract.spec.Contract.make {
    request {
        name('update email given invalid email format')
        method 'PUT'
        url '/my-service/api/2/root/email'
        headers {
            contentType('application/json')
        }
        body('{"email": "invalid.com"}')
    }
    response {
        status 400
        body(
            timestamp: $(consumer("2018-05-01T10:30:00.000+0000"), producer(regex(nonBlank()))),
            status: 400,
            error: "Bad Request",
            errors: [
                    [
                        codes: [
                            "Email.emailUpdateViewModel.email",
                            "Email.email",
                            "Email.java.lang.String",
                            "Email"
                        ],
                        arguments: [[
                                        codes: ["emailUpdateViewModel.email","email"],
                                        defaultMessage: "email",
                                        code: "email"
                                    ],
                                    [],
                                    [
                                        defaultMessage: ".*",
                                        codes: [".*"]
                                    ]
                        ],
                        defaultMessage: "must be a well-formed email address",
                        objectName: "emailUpdateViewModel",
                        field: "email",
                        rejectedValue: "invalid.com",
                        bindingFailure: false,
                        code: "Email"
                    ]
            ],
            message: "Validation failed for object='emailUpdateViewModel'. Error count: 1",
            path: "/my-service/api/2/root/email"
        )
    }
}
