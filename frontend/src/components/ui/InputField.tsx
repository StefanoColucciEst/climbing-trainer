import type { InputHTMLAttributes } from 'react'

interface InputFieldProps extends InputHTMLAttributes<HTMLInputElement> {
  label: string
}

export function InputField({ label, className = '', ...props }: InputFieldProps) {
  return (
    <div className={className}>
      <label className="block text-sm font-medium text-text-secondary mb-1">{label}</label>
      <input
        className="w-full border-0 border-b-2 border-gray-200 bg-transparent px-0 py-2 text-sm focus:outline-none focus:border-primary transition-colors"
        {...props}
      />
    </div>
  )
}
